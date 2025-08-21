package com.attendance.attendance.salary.repository;

import com.attendance.attendance.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository  extends JpaRepository<Salary, Long> {


    List<Salary> findAllByEmp_EmpId(Long empId); // 여러 급여를 반환
}
