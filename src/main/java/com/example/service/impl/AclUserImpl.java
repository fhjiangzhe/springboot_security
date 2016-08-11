package com.example.service.impl;

import com.example.domain.AclUser;
import com.example.mapper.UserMapper;
import com.example.service.AclUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JiangZhe on 16/7/29.
 */
@Service
public class AclUserImpl implements AclUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AclUser findByName(String username) {
        return userMapper.findByName(username);
    }
}
