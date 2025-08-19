package com.attendance.attendance.employee.controller;

import com.attendance.attendance.employee.entity.Emp;
import com.attendance.attendance.employee.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Controller
public class EmpController {

    private final EmpRepository empRepository;

    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        List<Emp> empList = empRepository.findAllWithSalary();
        model.addAttribute("empList", empList);
        return "emp/employees";
    }

}
