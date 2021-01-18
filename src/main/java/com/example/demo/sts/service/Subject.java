package com.example.demo.sts.service;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sub_num") private int subNum;
	@Column(name = "subject") private String subject;
	@Column(name = "description") private String description;

	@Builder
	private Subject(String subject, String description){
		this.subject = subject;
		this.description = description;
	}
}

/*
create table subjects (sub_num int primary key auto_increment, subject varchar(100), description varchar(200));
 */
