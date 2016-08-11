package com.example.service;

import com.example.domain.UserRole;
import java.util.List;
import java.util.Map;

/**
 * Created by JiangZhe on 16/7/29.
 */
public interface UserRoleService {

    List<UserRole> selectByMap(Map map);
}
