package com.attendance.attendance.leaverecord.repository;

import com.attendance.attendance.employee.entity.Emp;
import com.attendance.attendance.leaverecord.entity.Leaverecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leaverecord, Long> {
}
