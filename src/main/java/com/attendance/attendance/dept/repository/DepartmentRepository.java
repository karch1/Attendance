package com.attendance.attendance.dept.repository;

import com.attendance.attendance.dept.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value = "select d from Department d\n" +
            "where d.dept_Name like %:searchKeyword%")
    Page<Department> selectDeptList(
            @Param("searchKeyword") String searchKeyword,
            Pageable pageable
    );
}
