package com.example.service;

import com.example.domain.AclUser;

/**
 * Created by JiangZhe on 16/7/29.
 */
public interface AclUserService {

    /**
     * 根据用户名返回用户
     */
    AclUser findByName(String username);
}
