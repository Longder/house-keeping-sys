package com.longder.housekeeping.service.impl;

import com.longder.housekeeping.entity.Appointment;
import com.longder.housekeeping.entity.ServerComment;
import com.longder.housekeeping.entity.SysUser;
import com.longder.housekeeping.repository.AppointmentRepository;
import com.longder.housekeeping.repository.ServerCommentRepository;
import com.longder.housekeeping.security.SecurityUtil;
import com.longder.housekeeping.service.CommentManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * 评论管理的业务服务service实现
 */
@Service
public class CommentManageServiceImpl implements CommentManageService {

    @Resource
    private ServerCommentRepository serverCommentRepository;
    @Resource
    private AppointmentRepository appointmentRepository;

    /**
     * 添加一条评论
     *
     * @param serverComment
     */
    @Override
    @Transactional
    public void addOneComment(ServerComment serverComment) {
        //当前登录用户
        SysUser currentUser = SecurityUtil.getCurrentUser();
        assert currentUser != null;
        serverComment.setEmployer(currentUser);
        serverComment.setCommentDate(LocalDate.now());
        serverCommentRepository.save(serverComment);
        //处理预约中的评论状态
        Appointment appointment = appointmentRepository.findById(serverComment.getAppointmentId()).orElseThrow(RuntimeException::new);
        appointment.setCommented(true);
        appointmentRepository.save(appointment);
    }

    /**
     * 查看某服务的评价列表
     *
     * @param serverInfoId 服务id
     * @return 评价集合
     */
    @Override
    public List<ServerComment> listAllComment(Long serverInfoId) {
        return serverCommentRepository.listByServerInfoId(serverInfoId);
    }
}
