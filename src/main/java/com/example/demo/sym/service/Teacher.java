package com.example.demo.sym.service;

import com.example.demo.sts.service.Subject;
import com.example.demo.uss.service.Student;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="teachers")
public class Teacher{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tea_num") private int teaNum;
	@Column(name = "name") private String name;
	@Column(name = "email") private String email;
	@Column(name = "password") private String password;
	@Column(name = "profile_img") private String profileImg;

	@ManyToOne
	@JoinColumn(name = "sub_num")
	private Subject subject;

    public Teacher(String name, String email, String password, String profileImg, int subNum) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    	this.profileImg = profileImg;
    }

	@Builder
	private Teacher(int subNum, String name, String email, String password, String profileImg){
		this.name = name;
		this.email = email;
		this.password = password;
		this.profileImg = profileImg;
	}
}
/*
create table teachers(
	tea_num int primary key,
	name varchar2(20),
	email varchar2(20),
	password varchar2(20),
	subject varchar2(20),
	profile_img varchar2(200)
	)
*/
