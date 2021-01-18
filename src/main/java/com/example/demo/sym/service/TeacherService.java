package com.example.demo.sym.service;

import static com.example.demo.cmm.utl.Util.*;
import static com.example.demo.cmm.utl.Util.mySkip;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.DummyGenerator;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.Grade;
import com.example.demo.sts.service.GradeVo;
import com.example.demo.sts.service.SubjectMapper;

@Service
public class TeacherService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired TeacherMapper teacherMapper;
    @Autowired SubjectMapper subjectMapper;
    @Autowired DummyGenerator dummy;
    @Autowired Box<Object> bx;
    
    @Transactional
    public void  insertMany(int count) {
    	// teacher 는 subject 5 까지만 입력
    	var tlist = new ArrayList<Teacher>();
    	Teacher t = null;
    	for(int i = 0; i < count; i++) {
    		t = dummy.makeTeacher(i+1);
    		tlist.add(t);
    	}
    	teacherMapper.insertMany(tlist);
    }
    
    public int register(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }
    
    public Map<?, ?> selectAllBySubject(Box<String> param){
    	String pageNum = param.get("pageNum").toString();
    	String pageSize = param.get("pageSize").toString();
    	List<GradeVo> list = teacherMapper.selectAll(param.get());
    	
    	// IntSummaryStatistics is = list.stream().collect(summarizingInt(GradeVo::getScore)); // p.204
		IntSummaryStatistics is = null;
    	bx.put("max", is.getMax());
    	bx.put("min", is.getMin());
    	bx.put("sum", integer.apply(string.apply(is.getSum())));
    	bx.put("avg", integer.apply(string.apply(is.getAverage())));
    	bx.put("count", integer.apply(string.apply(is.getCount())));
    	
    	System.out.println(is);
    	
    	//POJO로 구현하는 Pagination
    	
    	bx.put("list", list.stream()
        		.skip(mySkip.apply(pageNum, pageSize))
        		.limit(integer.apply(pageSize))
        		.collect(toList()));
    	bx.put("page", new Pagination(integer.apply(pageSize), integer.apply(pageNum), list.size()));
    	
    	bx.put("subjects", subjectMapper.selectAllSubject()
		    				.stream()
		    				.collect(joining(",")));
    	/*
    	Optional<GradeVo> highScoreGrade = list.stream()
    										.collect(reducing( (g1, g2) -> g1.getScore() > g2.getScore() ? g1 : g2));
    	*/
    	bx.put("highScoreGrade", 0);
		return bx.get();
    }
}
