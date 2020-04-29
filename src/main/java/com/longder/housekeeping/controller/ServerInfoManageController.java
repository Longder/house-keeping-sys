package com.longder.housekeeping.controller;

import com.longder.housekeeping.entity.ServerInfo;
import com.longder.housekeeping.service.ServerInfoManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 服务信息相关管理的控制器
 */
@Slf4j
@Controller
@RequestMapping("/admin/serverInfo")
public class ServerInfoManageController {

    @Resource
    private ServerInfoManageService serverInfoManageService;

    /**
     * 员工查看自己发布的服务信息
     * @return 页面
     */
    @GetMapping("/listForStaff")
    public String listServerInfoForStaff(Model model){
        log.debug("员工查看服务信息列表");
        model.addAttribute("serverInfoList",serverInfoManageService.listMyServerInfo());
        return "server-info/list-for-staff";
    }

    /**
     * 去发布服务信息
     * @return 页面
     */
    @GetMapping("/toAdd")
    public String toAddServerInfo(){
        log.debug("去发布服务信息");
        return "server-info/add-server-info-modal";
    }

    /**
     * 发布服务信息
     * @param serverInfo 服务信息对象
     * @return
     */
    @PostMapping("/add")
    public String publishServerInfo(ServerInfo serverInfo){
        log.debug("发布服务信息");
        serverInfoManageService.publishOneServerInfo(serverInfo);
        return "redirect:/admin/serverInfo/listForStaff";
    }

    /**
     * 雇主查看服务信息
     * @param model
     * @return
     */
    @GetMapping("/listForEmployer")
    public String listServerInfoForEmployer(Model model){
        model.addAttribute("serverInfoList",serverInfoManageService.listServerInfoNotAppoint());
        return "server-info/list-for-employer";
    }
}
