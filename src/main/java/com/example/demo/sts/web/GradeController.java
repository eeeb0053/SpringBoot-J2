package com.example.demo.sts.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.service.CommonMapper;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.Grade;
import com.example.demo.sts.service.GradeMapper;
import com.example.demo.sts.service.GradeService;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.sym.service.ManagerService;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.uss.service.Student;
import com.example.demo.uss.service.StudentMapper;
import com.example.demo.uss.service.StudentService;
import static com.example.demo.cmm.utl.Util.*;

@RestController @RequestMapping("/grades")
public class GradeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired StudentService studentService;
    @Autowired GradeMapper gradeMapper;
    @Autowired CommonMapper commonMapper;
    @Autowired Pagination page;
    @Autowired GradeService gradeService;
    @Autowired SubjectService subjectService;
    @Autowired TeacherService teacherService;
    @Autowired ManagerService managerService;
    @Autowired Box<String> bx;
    
    @PostMapping("")
    public Messenger register(@RequestBody Grade grade){
        logger.info("등록하려는 학생 정보: "+grade.toString());
        return (gradeMapper.insert(grade) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }

    @GetMapping("/register")
    public Messenger registerMany(){
        var map = new HashMap<String, String>();
        logger.info("Grade List Register ...");
        gradeService.insertMany();
        map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.GRADES);
        return commonMapper.totalCount(map)!=0?Messenger.SUCCESS:Messenger.FAILURE;
	}
    
    
}
