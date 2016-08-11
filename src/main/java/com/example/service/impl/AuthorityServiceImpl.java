package com.example.service.impl;

import com.example.domain.Authority;
import com.example.mapper.AuthorityMapper;
import com.example.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JiangZhe on 16/7/30.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public List<Authority> selectAll() {
        return authorityMapper.selectAll();
    }
}
