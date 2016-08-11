package com.example.controller;

import com.example.domain.AclUser;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JiangZhe on 16/7/26.
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private UserMapper userMapper;

     @RequestMapping("testDemo")
    public String testDemo(){
        return "testDemo";
    }

    @RequestMapping("getUser")
    public AclUser getUser(){
        return userMapper.selectByPrimaryKey(1L);
    }

}
