package com.longder.housekeeping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理控制器
 */
@Controller
@RequestMapping("/user")
public class UserManageController {

    /**
     * 用户列表
     * @return
     */
    @RequestMapping("/list")
    public String userList(){
        return null;
    }
}
