package com.example.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by JiangZhe on 16/7/30.
 */
public class MySaltSource implements SaltSource {

    @Override
    public Object getSalt(UserDetails user) {
        return user.getUsername();
    }
}
