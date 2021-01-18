package com.example.demo.sym.web;

import com.example.demo.sym.service.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Box;
import com.example.demo.sym.service.ManagerMapper;
import com.example.demo.sym.service.ManagerService;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired ManagerService managerService;
    @Autowired ManagerMapper managerMapper;
    @Autowired Box<String> bx;
    
    @PostMapping("")
    public Messenger register(@RequestBody Manager manager) {
        logger.info("등록하려는 관리자 정보: "+manager.toString());
        return (managerService.register(manager) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }
    @PostMapping("/access")
    public Manager login(@RequestBody Manager manager) {
    	System.out.println("============= MGR ACCESS ============");
    	return managerMapper.access(manager);
    }
    
}
