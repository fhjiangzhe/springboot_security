package com.example.service.impl;

import com.example.domain.UserAuthority;
import com.example.mapper.UserAuthorityMapper;
import com.example.service.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by JiangZhe on 16/7/30.
 */
@Service
public class UserAuthorityServiceImpl implements UserAuthorityService {

    @Autowired
    private UserAuthorityMapper userAuthorityMapper;

    @Override
    public List<UserAuthority> selectByMap(Map map) {
        return userAuthorityMapper.selectByMap(map);
    }
}
