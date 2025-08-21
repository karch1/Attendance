package com.attendance.attendance.employee.controller;

import com.attendance.attendance.employee.dto.EmpDto;
import com.attendance.attendance.employee.entity.Emp;
import com.attendance.attendance.employee.repository.EmpRepository;
import com.attendance.attendance.employee.service.EmpService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Controller
public class EmpController {

    private final EmpRepository empRepository;
    private final EmpService empService;

    //    관리자 권한 페이지
    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<EmpDto> empList = empRepository.findAllEmpDto();
        model.addAttribute("empList", empList);
        return "emp/admin";
        }

    //    회원가입페이지(관리자권한으로 생성하기때문에 관리자권한 없으면 홈으로 보냄)
    @GetMapping("/admin/register")
    public String showRegisterForm() {
        return "emp/register";
    }

    @PostMapping("/admin/register")
    public String registerEmployee(EmpDto empDto) {
        empService.save(empDto);
        return "redirect:/admin";
    }

    @PostMapping("/login")
    public String login(@RequestParam Long empId,
                        @RequestParam String pw,
                        HttpSession session) {

        Emp emp = empRepository.findById(empId).orElse(null);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (emp == null || !encoder.matches(pw, emp.getPw())) {
            log.info("로그인 실패 empId={}", empId);
            return "redirect:/login";
        }

        log.info("로그인 성공 empId={} role={}", empId, emp.getRole()); // <--- 추가
        session.setAttribute("EMP_ID", emp.getEmpId());
        session.setAttribute("ROLE", emp.getRole());

        if ("ROLE_ADMIN".equals(emp.getRole())) {
            return "redirect:/admin";
        } else {
            return "redirect:/";
        }
    }



    @GetMapping("/login")
    public String showLoginPage() {
        return "emp/login"; // JSP 로그인 폼
    }
}
