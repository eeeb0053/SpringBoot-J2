package com.example.demo.cop.bbs.service;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="replies")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rep_num") private int repNum;
    @Column(name = "content") private String content;
    @Column(name = "art_num") private int artNum;
}
/*
create table replies(
	reply_num int primary key,
	content varchar2(20),
	art_num int,
	constraint replies_fk foreign key(art_num) references articles(art_num)
)
*/