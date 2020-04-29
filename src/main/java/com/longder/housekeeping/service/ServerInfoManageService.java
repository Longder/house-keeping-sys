package com.longder.housekeeping.service;

import com.longder.housekeeping.entity.ServerInfo;

import java.util.List;

/**
 * 服务信息管理业务
 */
public interface ServerInfoManageService {

    /**
     * 查询我的服务信息，雇员查看自己发布的
     * @return 服务信息集合
     */
    List<ServerInfo> listMyServerInfo();

    /**
     * 发布一条服务信息
     * @param serverInfo 服务信息对象
     */
    void publishOneServerInfo(ServerInfo serverInfo);

    /**
     * 查看未预约的服务信息
     * @return
     */
    List<ServerInfo> listServerInfoNotAppoint();
}
