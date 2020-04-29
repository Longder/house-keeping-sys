package com.longder.housekeeping.repository;

import com.longder.housekeeping.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 预约表数据操作
 */
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    /**
     * 根据雇主id查询预约
     * @param employerId
     * @return
     */
    @Query("select a from Appointment a where a.employer.id = :employerId")
    List<Appointment> listByEmployerId(@Param("employerId") Long employerId);

}
