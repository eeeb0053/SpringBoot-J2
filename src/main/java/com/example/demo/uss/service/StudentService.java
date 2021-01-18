package com.example.demo.uss.service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.DummyGenerator;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.uss.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService{
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    DummyGenerator dummy;
    @Autowired Box<String> bx;
    
    @Transactional
    public int insertMany(int count) {
    	for(int i = 0; i < count; i++) {
    		studentMapper.insert(dummy.makeStudent());
    	}
    	return count();    	
    }
    
    @Transactional
    public int truncate() {
    	bx.clear();
    	bx.put("TRUNCATE_STUDENTS", Sql.TRUNCATE.toString()+"Students");
    	studentMapper.truncate(bx);
    	return count() != 0 ? 0 : 1;
    }
    
    public int count() {
    	bx.clear();
    	bx.put("COUNT_STUDENTS", Sql.TOTAL_COUNT.toString()+"students");
    	return studentMapper.count(bx);
    }

    public List<Student> list(Pagination page){
    	/*
    	return studentMapper.list().stream()
    			.sorted(comparing(Student::getStuNum).reversed())
    			.skip(page.getPageSize() * (page.getPageNum()-1))
    			.limit(page.getPageSize())
    			.collect(Collectors.toList());
    	 */
		return null;
    }

    /*
    public List<Student> selectBirthday(Pagination page){
    	return studentMapper.list().stream()
    			.sorted(comparing(Student::getStuNum).reversed())
    			.skip(page.getPageSize() * (page.getPageNum()-1))
    			.limit(page.getPageSize())
    			.collect(Collectors.toList());
    } */
}
