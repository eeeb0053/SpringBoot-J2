package com.example.demo.sts.web;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.GradeService;
import com.example.demo.sts.service.Subject;
import com.example.demo.sts.service.SubjectRepository;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.sym.service.ManagerService;
import com.example.demo.sym.service.TeacherRepository;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.uss.service.StudentService;

@RestController @RequestMapping("/subjects")
public class SubjectController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired StudentService studentService;
    @Autowired SubjectRepository subjectRepository;
    @Autowired TeacherRepository teacherRepository;
    @Autowired Pagination page;
    @Autowired GradeService gradeService;
    @Autowired SubjectService subjectService;
    @Autowired TeacherService teacherService;
    @Autowired ManagerService managerService;
    @Autowired Box<String> bx;
    
    @PostMapping("")
    public Messenger register(@RequestBody Subject subject){
        logger.info("등록하려는 학생 정보: "+subject.toString());
        // Get the List
        List<String> g
                = Arrays.asList("geeks", "for", "geeks");

        // Collect the list as map
        // by groupingBy() method
        subjectService.groupBySubject(bx);
        subjectRepository.save(subject);
        return subjectRepository.count()!=0?Messenger.SUCCESS:Messenger.FAILURE;
    }
    @GetMapping("/groupBy/{examDate}/{subNum}")
    public Map<?, ?> totalScoreGroupBySubject(@PathVariable String examDate,
    										  @PathVariable String subNum){
    	bx.put("examDate", examDate);
    	bx.put("subNum", subNum);
    	subjectService.groupBySubject(bx);
    	return null;
    }
    
    @GetMapping("/groupByGrade/{examDate}/{subNum}")
    public Map<?, ?> groupByGrade(@PathVariable String examDate,
    							  @PathVariable String subNum){
    	bx.put("examDate", examDate);
    	bx.put("subNum", subNum);
    	subjectService.groupBySubject(bx);
    	return null;
    }
    
    
}
