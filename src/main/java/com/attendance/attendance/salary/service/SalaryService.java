package com.attendance.attendance.salary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SalaryService {
<<<<<<< Updated upstream
=======
    private final SalaryRepository salaryRepository;

    // 등록
    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

//    전체 조회
    public List<Salary> getAllSalary() {
        return salaryRepository.findAll();
    }
//  사원별 조회
    public Salary getSalaryByEmpId(Long empId) {
        return salaryRepository.findByEmp_EmpId(empId);
    }
>>>>>>> Stashed changes
}
