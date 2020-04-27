package com.longder.housekeeping.service.impl;

import com.longder.housekeeping.entity.SysRole;
import com.longder.housekeeping.entity.SysUser;
import com.longder.housekeeping.entity.SysUserRole;
import com.longder.housekeeping.repository.SysUserRepository;
import com.longder.housekeeping.repository.SysUserRoleRepository;
import com.longder.housekeeping.service.UserManageService;
import com.longder.housekeeping.util.EncryptionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理服务业务
 */
@Service
public class UserManageServiceImpl implements UserManageService {
    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private SysUserRoleRepository sysUserRoleRepository;
    /**
     * 保存一个用户，新增和修改都可用
     *
     * @param sysUser
     * @param role
     */
    @Override
    @Transactional
    public void saveOneUser(SysUser sysUser, SysRole role) {
        if(ObjectUtils.isEmpty(sysUser.getId())){//空的 新增
            //处理下密码
            sysUser.setPassword(EncryptionUtil.encrypt(sysUser.getPassword().trim()));
            //存用户
            sysUserRepository.save(sysUser);
            SysUserRole userRole = new SysUserRole(sysUser,role);
            //存角色
            sysUserRoleRepository.save(userRole);
        }
    }

    /**
     * 检查登录名
     *
     * @param loginName 登录名
     * @return true:可以注册  false：不能注册
     */
    @Override
    public Boolean checkLoginName(String loginName) {
        SysUser sysUser = sysUserRepository.getByLoginName(loginName);
        return ObjectUtils.isEmpty(sysUser);
    }

    /**
     * 查询所有用户
     *
     * @return 用户集合
     */
    @Override
    public List<SysUser> listAllUser() {
        List<SysUser> sysUserList = sysUserRepository.findAll();
        //封装展示用的角色
        sysUserList.forEach(SysUser::fillRole);
        return sysUserList;
    }

    /**
     * 查询获取一个用户
     *
     * @param userId 用户Id
     * @return 用户对象
     */
    @Override
    public SysUser getOneUser(Long userId) {
        return sysUserRepository.findById(userId).orElseThrow(RuntimeException::new);
    }
}
