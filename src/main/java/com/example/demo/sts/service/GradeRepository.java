package com.example.demo.sts.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cmm.utl.Vector;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

}