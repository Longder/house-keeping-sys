package com.longder.housekeeping.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 家政服务信息，又家政服务人员发布
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "SERVER_INFO")
public class ServerInfo extends BaseIdEntity{
    /**
     * 服务信息标题
     */
    @Column(name = "title_")
    private String title;

    /**
     * 内容描述
     */
    @Column(name = "content_")
    private String content;

    /**
     * 服务人员
     */
    @ManyToOne
    @JoinColumn(name = "staff_id_")
    private SysUser staff;

    /**
     * 是否被预约
     * true:被预约
     * false:未被预约
     */
    @Column(name = "appointed_")
    private Boolean appointed;
}
