package com.attendance.attendance.employee.repository;

import com.attendance.attendance.employee.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, String> {
}
