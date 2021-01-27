package com.example.demo.sts.web;


import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.Grade;
import com.example.demo.sts.service.GradeRepository;
import com.example.demo.sts.service.GradeService;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.sym.service.ManagerService;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.uss.service.StudentService;

@CrossOrigin(origins = "*")
@RestController @RequestMapping("/grades")
public class GradeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired StudentService studentService;
    @Autowired GradeRepository gradeRepository;
    @Autowired Pagination page;
    @Autowired GradeService gradeService;
    @Autowired SubjectService subjectService;
    @Autowired TeacherService teacherService;
    @Autowired ManagerService managerService;
    @Autowired Box<String> bx;
    
    @PostMapping("")
    public Messenger register(@RequestBody Grade grade){
        gradeRepository.save(grade);
        return Messenger.SUCCESS;
    }

    @GetMapping("/register")
    public Messenger registerMany(){
        var map = new HashMap<String, String>();
        logger.info("Grade List Register ...");
        gradeService.insertMany();
        map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.GRADES);
        return gradeRepository.count()!=0?Messenger.SUCCESS:Messenger.FAILURE;
	}
    
    
}
