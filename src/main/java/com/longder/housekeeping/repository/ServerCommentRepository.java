package com.longder.housekeeping.repository;

import com.longder.housekeeping.entity.ServerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 服务评价数据操作对象
 */
public interface ServerCommentRepository extends JpaRepository<ServerComment,Long> {

    /**
     * 根据服务id查询
     * @param serverInfoId
     * @return
     */
    @Query("SELECT C FROM ServerComment C where C.serverInfo.id = :serverInfoId")
    List<ServerComment> listByServerInfoId(@Param("serverInfoId") Long serverInfoId);
}
