package com.attendance.attendance.employee.repository;

import com.attendance.attendance.employee.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Emp, String> {

    @Query("SELECT e FROM Emp e JOIN FETCH e.salary")
    List<Emp> findAllWithSalary();

}
