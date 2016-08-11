package com.example.service;

import com.example.domain.UserAuthority;

import java.util.List;
import java.util.Map;

/**
 * Created by JiangZhe on 16/7/30.
 */
public interface UserAuthorityService {

    List<UserAuthority> selectByMap(Map map);
}
