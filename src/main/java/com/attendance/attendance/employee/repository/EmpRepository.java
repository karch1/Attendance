package com.attendance.attendance.employee.repository;

import com.attendance.attendance.employee.dto.EmpDto;
import com.attendance.attendance.employee.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
    // 엔티티 전체 조회
    List<Emp> findAll();

    // DTO로 조회 (JPQL + 생성자 표현식)
    // EmpRepository
    @Query("SELECT new com.attendance.attendance.employee.dto.EmpDto(" +
            "e.empId, e.name, e.gender, e.phone, e.dept.deptId) " +
            "FROM Emp e")
    List<EmpDto> findAllEmpDto();


}
