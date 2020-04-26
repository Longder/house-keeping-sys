package com.longder.housekeeping.controller;

import com.longder.housekeeping.entity.SysUser;
import com.longder.housekeeping.service.UserManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
public class MainController {

    @Resource
    private UserManageService userManageService;

    /**
     * 主页默认跳转到登陆页
     * @return
     */
    @GetMapping("/")
    public String index(){
        return "redirect:toLogin";
    }

    /**
     * 去登陆页
     * @return
     */
    @GetMapping("/toLogin")
    public String toLogin(){
        log.debug("去登陆页面!");
        return "login";
    }

    /**
     * 去注册页面
     * @return
     */
    @GetMapping("/toRegister")
    public String toRegister(){
        log.debug("去注册页面");
        return "register";
    }


    /**
     * 检查登录名
     * @return
     */
    @ResponseBody
    @PostMapping("/checkLoginName")
    public Boolean checkLoginName(String loginName){
        log.debug("检查登录名：{}",loginName);
        return userManageService.checkLoginName(loginName);
    }

    /**
     * 注册一个用户
     * @param sysUser
     * @return
     */
    @PostMapping("/register")
    public String register(SysUser sysUser){
        log.debug("开始注册用户，登录名：{}",sysUser.getLoginName());
        userManageService.saveOneUser(sysUser,sysUser.getRole());
        return "redirect:toLogin";
    }

    /**
     * 后台主页,登陆后访问的首页
     * @return
     */
    @GetMapping("/admin/index")
    public String adminIndex(){
        log.debug("去后台主页");
        return "index";
    }

    /**
     * 仪表盘，欢迎页面
     * @return
     */
    @GetMapping("/admin/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
