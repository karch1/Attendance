package com.attendance.attendance.employee.service;

import com.attendance.attendance.department.entity.Department;
import com.attendance.attendance.department.repository.DepartmentRepository;
import com.attendance.attendance.employee.dto.EmpDto;
import com.attendance.attendance.employee.entity.Emp;
import com.attendance.attendance.employee.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmpService {

    private final EmpRepository empRepository;
    private final DepartmentRepository departmentRepository;

    public void save(EmpDto empDto) {
        Department department = departmentRepository.findById(empDto.getDeptId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 부서입니다."));

        Emp emp = new Emp();
        emp.setName(empDto.getName());
        emp.setGender(empDto.getGender());
        emp.setPhone(empDto.getPhone());
        emp.setPw(empDto.getPw());
        emp.setRole(empDto.getRole());
        emp.setDept(department);

        empRepository.save(emp);
    }

}
