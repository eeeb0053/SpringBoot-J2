package com.example.demo.sym.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Box;
import com.example.demo.sts.service.SubjectRepository;
import com.example.demo.sym.service.Teacher;
import com.example.demo.sym.service.TeacherRepository;
import com.example.demo.sym.service.TeacherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*")
@RestController @RequestMapping("/teachers")
public class TeacherController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired TeacherService teacherService;
    @Autowired TeacherRepository teacherRepository;
    @Autowired SubjectRepository subjectRepository;
    @Autowired Box<String> bx;
    
    @PostMapping("")
    public Messenger register(@RequestBody Teacher teacher) {
        logger.info("등록하려는 관리자 정보: "+teacher.toString());
        teacherRepository.save(teacher);
        return Messenger.SUCCESS ;
    }
    @PostMapping("/access")
    public Teacher login(@RequestBody Teacher teacher) {
    	System.out.println("============= TEA ACCESS ============");
        // teacherRepository.findById(teacher.getTeaNum());
        return null;
    }

    @GetMapping("/page/{pageSize}/{pageNum}/subject/{subNum}/{examDate}")
    public Map<?, ?> selectAllBySubject(@PathVariable String pageSize, 
			@PathVariable String pageNum, @PathVariable String subNum, @PathVariable String examDate){
    	logger.info("=========== SelectAllBySubject Excuted...");
    	bx.put("pageSize", pageSize);
    	bx.put("pageNum", pageNum);
    	bx.put("subNum", subNum);
    	bx.put("examDate", examDate);
    	teacherService.selectAllBySubject(bx);
    	
    	return null;
    }
}
