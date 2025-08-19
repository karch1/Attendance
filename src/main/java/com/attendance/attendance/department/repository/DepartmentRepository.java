package com.attendance.attendance.department.repository;

import com.attendance.attendance.department.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value = "select d from Department d\n" +
            "where d.deptName like %:searchKeyword%")
    Page<Department> selectDeptList(
            @Param("searchKeyword") String searchKeyword,
            Pageable pageable
    );
}
