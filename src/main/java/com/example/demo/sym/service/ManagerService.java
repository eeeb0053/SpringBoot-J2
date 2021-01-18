package com.example.demo.sym.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cmm.utl.DummyGenerator;
import com.example.demo.sts.service.Grade;

@Service
public class ManagerService{
    @Autowired ManagerMapper managerMapper;
    @Autowired DummyGenerator dummy;
    
    public int register(Manager manager) {
        return managerMapper.insert(manager);
    }
    
    @Transactional
    public int insertMany(int count) {
    	List<Manager> list = new ArrayList<Manager>();
    	Manager m = null;
    	
    	for(int i = 0; i < count; i++) {
    		m = dummy.makeManager();
    		list.add(m);
    	}
    	return managerMapper.insertMany(list);
 	
    }
    
}
