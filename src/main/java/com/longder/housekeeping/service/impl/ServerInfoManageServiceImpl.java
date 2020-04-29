package com.longder.housekeeping.service.impl;

import com.longder.housekeeping.entity.ServerInfo;
import com.longder.housekeeping.entity.SysUser;
import com.longder.housekeeping.repository.ServerInfoRepository;
import com.longder.housekeeping.security.SecurityUtil;
import com.longder.housekeeping.service.ServerInfoManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务信息管理业务的实现类
 */
@Service
public class ServerInfoManageServiceImpl implements ServerInfoManageService {

    @Resource
    private ServerInfoRepository serverInfoRepository;

    /**
     * 查询我的服务信息，雇员查看自己发布的
     *
     * @return 服务信息集合
     */
    @Override
    public List<ServerInfo> listMyServerInfo() {
        //当前登录用户
        SysUser currentUser = SecurityUtil.getCurrentUser();
        assert currentUser != null;
        return serverInfoRepository.listByStaff(currentUser.getId());
    }

    /**
     * 发布一条服务信息
     *
     * @param serverInfo 服务信息对象
     */
    @Override
    @Transactional
    public void publishOneServerInfo(ServerInfo serverInfo) {
        //当前登录用户
        SysUser currentUser = SecurityUtil.getCurrentUser();
        assert currentUser != null;
        serverInfo.setStaff(currentUser);
        //刚发布还没预约
        serverInfo.setAppointed(false);
        serverInfoRepository.save(serverInfo);
    }

    /**
     * 查看未预约的服务信息
     *
     * @return
     */
    @Override
    public List<ServerInfo> listServerInfoNotAppoint() {
        return serverInfoRepository.listNotAppoint();
    }
}
