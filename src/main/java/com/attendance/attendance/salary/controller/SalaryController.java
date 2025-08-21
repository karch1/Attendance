package com.attendance.attendance.salary.controller;

import com.attendance.attendance.employee.entity.Emp;
import com.attendance.attendance.employee.repository.EmpRepository;
import com.attendance.attendance.salary.dto.SalaryDto;
import com.attendance.attendance.salary.entity.Salary;
import com.attendance.attendance.salary.service.SalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Controller
public class SalaryController {

    private final SalaryService salaryService;
    private final EmpRepository empRepository;

    //  급여 전체조회 (모든 사원 접근 가능)
    @GetMapping("/salary/list")
    public String listSalary(Model model) {
        model.addAttribute("salaryList", salaryService.getAllSalary());
        return "salary/list";
    }

    //  급여 등록 폼 페이지 (관리자만 가능)
    @PreAuthorize("hasRole('ROLE_ADMIN')")      // ROLE_ADMIN 권한자만 가능
    @GetMapping("/salary/register")
    public String showRegisterFrom(Model model) {
//        사원 목록 조회 후 select 박스 전달
        List<Emp> empList = empRepository.findAll();
        model.addAttribute("empList", empList);
        return "salary/register";
    }

    // 급여 등록 처리 (관리자만 접근)
    @PreAuthorize("hasRole('ROLE_ADMIN')")  // ADMIN 권한 체크
    @PostMapping("/salary/register")
    public String registerSalary(SalaryDto salaryDto) {
        Salary salary = new Salary();
        // empId만 설정하고 나머지는 null로 처리
        salary.setEmp(new Emp(salaryDto.getEmpId(), null, null, null, null, null, null));
        salary.setPayDate(salaryDto.getPayDate());
        salary.setBaseSalary(salaryDto.getBaseSalary());
        salary.setBonus(salaryDto.getBonus());
        salary.setWithholding(salaryDto.getWithholding());
        salaryService.saveSalary(salary);
        return "redirect:/salary/list"; // 등록 후 목록 페이지로 리다이렉트
    }
}
