package com.example.demo.sym.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.sts.service.Grade;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
