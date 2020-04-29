package com.longder.housekeeping.service;

import com.longder.housekeeping.entity.Appointment;

import java.util.List;

/**
 * 预约管理的业务service
 */
public interface AppointmentManageService {

    /**
     * 生成预约服务
     * @param serverInfoId 服务信息id
     */
    void generateAppointment(Long serverInfoId);

    /**
     * 查询我的预约信息列表
     * @return
     */
    List<Appointment> listMyAppointment();

    /**
     * 完成家政服务
     * @param appointmentId
     */
    void completeAppointment(Long appointmentId);
}
