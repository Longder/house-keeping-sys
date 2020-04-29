package com.longder.housekeeping.repository;

import com.longder.housekeeping.entity.ServerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 服务信息表的数据访问对象
 */
public interface ServerInfoRepository extends JpaRepository<ServerInfo,Long> {

    /**
     * 根据员工id查询服务信息
     * @param staffId 员工Id
     * @return 服务信息集合
     */
    @Query("select i from ServerInfo i where i.staff.id = :staffId")
    List<ServerInfo> listByStaff(@Param("staffId") Long staffId);

    /**
     * 查询未预约的服务信息
     * @return
     */
    @Query("select i from ServerInfo i where i.appointed = false ")
    List<ServerInfo> listNotAppoint();
}
