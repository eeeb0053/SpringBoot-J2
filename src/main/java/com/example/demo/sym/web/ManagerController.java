package com.example.demo.sym.web;

import com.example.demo.sym.service.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Box;
import com.example.demo.sym.service.ManagerRepository;
import com.example.demo.sym.service.ManagerService;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/managers")
public class ManagerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired ManagerService managerService;
    @Autowired ManagerRepository managerRepository;
    @Autowired Box<String> bx;
    
    @PostMapping("")
    public Messenger register(@RequestBody Manager manager) {
        logger.info("등록하려는 관리자 정보: "+manager.toString());
        managerRepository.save(manager);
        return Messenger.SUCCESS;
    }
    @PostMapping("/access")
    public Optional<Manager> login(@RequestBody Manager manager) {
    	System.out.println("============= MGR ACCESS ============");
        return managerRepository.findById(0);
    }
    
}
