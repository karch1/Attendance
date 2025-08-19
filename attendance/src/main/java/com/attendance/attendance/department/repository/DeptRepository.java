package com.attendance.attendance.department.repository;

import com.attendance.attendance.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department,Long> {
}
