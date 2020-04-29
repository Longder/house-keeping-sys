package com.longder.housekeeping.entity;

import com.longder.housekeeping.entity.enums.ServerState;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 预约表的实体
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "APPOINTMENT")
public class Appointment extends BaseIdEntity{

    /**
     * 对应的服务信息
     */
    @ManyToOne
    @JoinColumn(name = "server_info_id_")
    private ServerInfo serverInfo;

    /**
     * 服务状态
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "server_state_")
    private ServerState serverState;

    /**
     * 雇主
     */
    @ManyToOne
    @JoinColumn(name = "employer_id_")
    private SysUser employer;

    /**
     * 是否已评论
     * true 已评论
     * false 未评论
     */
    @Column(name = "commented_")
    private Boolean commented;

}
