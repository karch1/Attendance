package com.attendance.attendance.department.service;

import com.attendance.attendance.common.ErrorMsg;
import com.attendance.attendance.common.MapStruct;
import com.attendance.attendance.department.dto.DepartmentDto;
import com.attendance.attendance.department.entity.Department;
import com.attendance.attendance.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    //    DB CRUD 클래스 받기 : JPA 제공 함수 사용 가능
    private final DepartmentRepository departmentRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

    // 2. 전체 조회
    public Page<DepartmentDto> selectDeptList(String searchKeyword, Pageable pageable) {
        Page<Department> page= departmentRepository.selectDeptList(searchKeyword, pageable);
        return page.map(department -> mapStruct.toDto(department));
    }
}
