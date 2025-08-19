package com.attendance.attendance.attendancerecord.repository;

import com.attendance.attendance.attendancerecord.entity.Attendancerecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttRepository extends JpaRepository<Attendancerecord,Long> {
}
