package com.longder.housekeeping.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 评价管理的控制器
 */
@Slf4j
@Controller
@RequestMapping("/admin/comment")
public class CommentManageController {

    /**
     * 去添加评论
     * @return
     */
    @GetMapping("/toAdd")
    public String toAddComment(Long appointmentId){

        return "comment/add-comment-modal";
    }
}
