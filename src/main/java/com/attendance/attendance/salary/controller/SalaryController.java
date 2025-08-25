package com.attendance.attendance.salary.controller;

import com.attendance.attendance.employee.entity.Emp;
import com.attendance.attendance.employee.repository.EmpRepository;
import com.attendance.attendance.salary.dto.SalaryDto;
import com.attendance.attendance.salary.entity.Salary;
import com.attendance.attendance.salary.repository.SalaryRepository;
import com.attendance.attendance.salary.service.SalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Controller
public class SalaryController {

    private final SalaryService salaryService;
    private final EmpRepository empRepository;
    private final SalaryRepository salaryRepository;

    /**
     * 📌 전체 급여 목록 조회 (관리자 전용)
     * - ROLE_ADMIN 권한을 가진 사용자만 접근 가능
     * - 모든 사원의 급여 내역을 조회하여 리스트 페이지로 전달
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/salary/list")
    public String listSalary(Model model) {
        model.addAttribute("salaryList", salaryService.getAllSalary());
        return "salary/list"; // -> /WEB-INF/views/salary/list.jsp 렌더링
    }

    /**
     * 📌 로그인한 사원의 개인 급여 내역 조회
     * - 로그인한 사용자의 empId를 기준으로 조회
     * - 연도/월이 파라미터로 전달되면 해당 월만 조회
     * - 파라미터가 없으면 현재 연월 기준으로 조회
     */
    @GetMapping("/salary/mine")
    public String mySalary(
            Model model,
            Principal principal, // 현재 로그인 사용자 정보
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month
    ) {
        if (principal == null) { // 로그인 안 되어 있으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // principal.getName() → 현재 로그인한 유저의 ID (여기서는 empId를 String으로 받음)
//         사번을 로그인 id로 쓰기때문에 Principal.getName() 꺼내기 위해서 String으로 받는거임
        Long empId = Long.valueOf(principal.getName());

        // 연도/월 기본값 = 현재 시점
        int y = (year != null) ? year : LocalDate.now().getYear();
        int m = (month != null) ? month : LocalDate.now().getMonthValue();

        // Service 호출 → 해당 사원의 특정 연/월 급여 목록 조회
        List<Salary> salaryList = salaryService.getSalaryByEmpIdAndMonth(empId, y, m);

        // View에 전달할 데이터 바인딩
        model.addAttribute("salaryList", salaryList);
        model.addAttribute("year", y);
        model.addAttribute("month", m);

        return "salary/mine"; // -> /WEB-INF/views/salary/mine.jsp
    }

    /**
     * 📌 특정 사원의 급여 전체 내역 조회 (내부 메서드)
     * - Repository 호출하여 empId로 정렬된 급여 데이터 반환
     * - Controller 내 다른 기능에서 재사용 가능
     */
    public List<Salary> getSalaryByEmpId(Long empId) {
        return salaryRepository.findAllByEmp_EmpIdOrderByPayDateDesc(empId);
    }

    /**
     * 📌 급여 등록 폼 페이지 (관리자 전용)
     * - 모든 사원 목록을 조회하여 select box에 전달
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/salary/register")
    public String showRegisterFrom(Model model) {
        List<Emp> empList = empRepository.findAll(); // 사원 전체 조회
        model.addAttribute("empList", empList);
        return "salary/register"; // -> /WEB-INF/views/salary/register.jsp
    }

    /**
     * 📌 급여 등록 처리 (관리자 전용)
     * - DTO → Entity 변환
     * - 같은 사원/날짜 급여가 이미 있으면 update, 없으면 insert
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/salary/register")
    public String registerSalary(SalaryDto salaryDto) {

        // DTO -> Entity 변환
        Salary salary = new Salary();
        salary.setEmp(new Emp(salaryDto.getEmpId(), null, null, null, null, null, null)); // Emp 객체 생성 (id만 세팅)
        salary.setPayDate(salaryDto.getPayDate());      // 지급일
        salary.setBaseSalary(salaryDto.getBaseSalary()); // 기본급
        salary.setBonus(salaryDto.getBonus());          // 상여
        salary.setWithholding(salaryDto.getWithholding()); // 공제

        // Service 호출 → 저장 or 업데이트
        salaryService.saveOrUpdateSalary(salary);

        // 등록 완료 후 목록 페이지로 이동
        return "redirect:/salary/list";
    }
}
