package com.example.demo.sym.service;

import com.example.demo.uss.service.Student;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mgr_num") private int mgrNum;
    @Column(name = "email") private String email;
    @Column(name = "password") private String password;
    @Column(name = "name") private String name;
    @Column(name = "profile_img") private String profileImg;

    @OneToMany(mappedBy = "manager")
    private List<Student> studentList = new ArrayList<>();

    @Builder
    private Manager(String email, String password, String name, String profileImg){
        this.email = email;
        this.password = password;
        this.name = name;
        this.profileImg = profileImg;
    }

    public Manager(int mgrNum, String email, String password, String name, String profileImg){
        this.mgrNum = mgrNum;
        this.email = email;
        this.password = password;
        this.name = name;
        this.profileImg = profileImg;
    }

}