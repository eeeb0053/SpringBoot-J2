package com.example.demo.uss.service;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="students")
public class Student{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stu_num") private int stuNum;
	@Column(name = "mgr_num") private int mgrNum;
	@Column(name = "userid") private String userid;
	@Column(name = "password") private String password;
	@Column(name = "name") private String name;
	@Column(name = "birthday") private String birthday;
	@Column(name = "gender") private String gender;
	@Column(name = "reg_date") private String regDate;
	@Column(name = "profile_img") private String profileImg;

    public Student(String userid, String password, String name, String birthday,
    			   String gender, String regDate, String profileImg, int mgrNum) {
    	this.userid = userid;
    	this.password = password;
    	this.name = name;
    	this.birthday = birthday;
    	this.gender = gender;
    	this.regDate = regDate;
    	this.profileImg = profileImg;
    	this.mgrNum = mgrNum;
    }
	@Builder
	private Student(int mgrNum, String userid, String password, String name, String birthday,
				   String gender, String regDate, String profileImg) {
		this.mgrNum = mgrNum;
    	this.userid = userid;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.regDate = regDate;
		this.profileImg = profileImg;
	}
}
/*
create table students(
	stu_num int primary key,
	userid varchar2(20),
	password varchar2(20),
	name varchar2(20),
	ssn varchar2(20),
	reg_date varchar2(20),
	subject varchar2(20),
	profile_img varchar2(200),
	tea_num int,
	constraint students_fk foreign key(tea_num) references teachers(tea_num)
	)
 */