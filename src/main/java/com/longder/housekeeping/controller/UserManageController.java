package com.longder.housekeeping.controller;

import com.longder.housekeeping.entity.SysUser;
import com.longder.housekeeping.service.UserManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 用户管理控制器
 */
@Slf4j
@Controller
@RequestMapping("/admin/user")
public class UserManageController {

    @Resource
    private UserManageService userManageService;
    /**
     * 用户列表
     * @return
     */
    @RequestMapping("/list")
    public String userList(Model model){
        log.debug("用户列表页");
        model.addAttribute("userList",userManageService.listAllUser());
        return "user/user-list";
    }

    /**
     * 去编辑用户
     * @param userId
     * @return
     */
    @GetMapping("/toEdit")
    public String toEdit(Long userId,Model model){
        log.debug("去编辑用户页面");
        model.addAttribute("user",userManageService.getOneUser(userId));
        return "user/edit-user-modal";
    }

    /**
     * 编辑用户
     * @param sysUser
     * @return
     */
    @PostMapping("/edit")
    public String edit(SysUser sysUser){
        log.debug("编辑用户");
        userManageService.saveOneUser(sysUser,null);
        return "redirect:/admin/user/list";
    }

}
