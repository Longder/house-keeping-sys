package com.longder.housekeeping.service;

import com.longder.housekeeping.entity.SysRole;
import com.longder.housekeeping.entity.SysUser;

import java.util.List;

/**
 * 用户管理服务业务
 */
public interface UserManageService {

    /**
     * 保存一个用户，新增和修改都可用
     * @param sysUser 用户对象
     * @param role 角色
     */
    void saveOneUser(SysUser sysUser, SysRole role);

    /**
     * 检查登录名
     * @param loginName 登录名
     * @return true:可以注册  false：不能注册
     */
    Boolean checkLoginName(String loginName);

    /**
     * 查询所有用户
     * @return 用户集合
     */
    List<SysUser> listAllUser();
}
