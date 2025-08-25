package com.attendance.attendance.salary.service;

import com.attendance.attendance.salary.entity.Salary;
import com.attendance.attendance.salary.repository.SalaryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;

    // 등록 또는 수정
//    급여 등록 또는 수정 (사번 + 지급일 기준으로 존재 여부 확인)
//    같은 사원(empId) + 같은 지급일(payDate)이 이미 존재하면 → update 없으면 새로 insert
    @Transactional
    public Salary saveOrUpdateSalary(Salary salary) {
        Long empId = salary.getEmp().getEmpId();
        LocalDate payDate = salary.getPayDate();

        return salaryRepository.findByEmp_EmpIdAndPayDate(empId, payDate)
                .map(existing -> {
                    // 이미 존재하면 값 업데이트
                    existing.setBaseSalary(salary.getBaseSalary());     // 기본급 수정
                    existing.setBonus(salary.getBonus());               // 상여금 수정
                    existing.setWithholding(salary.getWithholding());   // 공제금 수정
                    return salaryRepository.save(existing);
                })
                .orElseGet(() -> salaryRepository.save(salary)); // 없으면 새로 등록
    }

    // 급여 전체 조회 (관리자용)
    public List<Salary> getAllSalary() {
        return salaryRepository.findAll();
    }

    //  특정 사원의 급여 내역 전체 조회 (최신 지급일순 정렬)
    public List<Salary> getSalaryByEmpId(Long empId) {
        return salaryRepository.findAllByEmp_EmpIdOrderByPayDateDesc(empId);
    }

    //  특정 사원의 연/월별 급여 조회
    public List<Salary> getSalaryByEmpIdAndMonth(Long empId, int year, int month) {
        return salaryRepository.findByEmpIdAndYearAndMonth(empId, year, month);
    }


}
