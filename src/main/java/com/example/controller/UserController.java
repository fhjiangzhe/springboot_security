package com.example.controller;

import com.example.domain.UserAuthority;
import com.example.security.UserContextHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Created by JiangZhe on 16/7/30.
 */
@Controller
public class UserController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    @ResponseBody
    public List<UserAuthority> index(){
        List<UserAuthority> userAuthorities = UserContextHelper.getUserContext().getUserAuthorities();
        return  userAuthorities;
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("timeout")
    public String timeout(){
        return "timeout";
    }
}
