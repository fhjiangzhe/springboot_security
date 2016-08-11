package com.example.service;


import com.example.security.UserContext;

public interface SecurityManager {

	UserContext getUserContext(String paramString);
}
