package com.longder.housekeeping.repository;


import com.longder.housekeeping.entity.SysRole;
import com.longder.housekeeping.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    /**
     * 根据登录名查询
     * @param loginName
     * @return
     */
    @Query("select s from SysUser s where s.loginName = :loginName")
    SysUser getByLoginName(@Param("loginName") String loginName);

    @Query("select distinct s from SysUser s left join s.roles r where r.role = :role ")
    List<SysUser> listByRole(@Param("role") SysRole role);
}
