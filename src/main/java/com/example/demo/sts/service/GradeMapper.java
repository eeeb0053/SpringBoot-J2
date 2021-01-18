package com.example.demo.sts.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.cmm.utl.Vector;

@Repository
public interface GradeMapper {
   public int insertMany(Vector<Grade> vc);
   public Vector<GradeVo> selectJoinAll(String examDate);
   public int insert(Grade grade);
   public Vector<Grade> selectSome(Grade grade);
   public Grade selectOne(Grade grade);
   public void update(Grade grade);
   public void delete(Grade grade);
}