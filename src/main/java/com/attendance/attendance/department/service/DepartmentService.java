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
import org.springframework.transaction.annotation.Transactional;

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
    public void save(DepartmentDto departmentDto) {
//        JPA 저장 함수 실행 : return 값 : 저장된 객체
        Department dept=mapStruct.toEntity(departmentDto);
        departmentRepository.save(dept);
    }
    public DepartmentDto findById(long deptId) {
//        JPA 상세조회 함수 실행
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException(errorMsg.getMessage("errors.not.found")));

        return mapStruct.toDto(dept);
    }
    @Transactional
    public void updateFromDto(DepartmentDto departmentDto) {
//        JPA 저장 함수 실행 : return 값 : 저장된 객체
        Department dept=departmentRepository.findById(departmentDto.getDeptId())
                .orElseThrow(() -> new RuntimeException(errorMsg.getMessage("errors.not.found")));

        mapStruct.updateFromDto(departmentDto, dept);
//        deptRepository.save(dept);     // dirty checking 으로 인해 필요없음
    }
    //    삭제 함수
    public void deleteById(long deptId) {
        departmentRepository.deleteById(deptId);
    }
}
