package com.example.demo.sts.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data @Component @Lazy
public class GradeVo { // Big Bean 으로 부르기도 함
	//Grade
    private String subject, grade, examDate, passExam;
    private int stuNum, score, grdNum;
    //Subject
	private int subNum, teaNum;
	private String desciption;
	// Teacher
    private String teaName, teaEmail, teaPassword, teaProfileImg;
	// Student
    private String userid, stuPassword, stuName, birthday, gender, regDate, stuProfileImg;
}
