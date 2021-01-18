package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;

@Repository
public interface StudentMapper {
	public int insert(Student student);
	public Student login(Student student);
	public Student selectById(String userid);
	public int update(Student student);
	public int delete(Student student);
	public void truncate(Box<String> bx);
	public int count(Box<String> bx);
	public List<Student> selectAll(Pagination page);
	public List<Student> list();
}
