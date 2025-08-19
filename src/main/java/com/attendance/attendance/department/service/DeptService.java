package com.attendance.attendance.department.service;

import com.attendance.attendance.common.ErrorMsg;
import com.attendance.attendance.common.MapStruct;
import com.attendance.attendance.department.dto.DeptDto;
import com.attendance.attendance.department.entity.Department;
import com.attendance.attendance.department.repository.DeptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeptService {
    //    DB CRUD 클래스 받기 : JPA 제공 함수 사용 가능
    private final DeptRepository deptRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

    public Page<DeptDto> selectDeptList(String searchKeyword, Pageable pageable) {
        Page<Department> page= deptRepository.selectDeptList(searchKeyword, pageable);
        return page.map(department -> mapStruct.toDto(department));
    }
}
