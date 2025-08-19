package com.attendance.attendance.department.controller;

import com.attendance.attendance.department.dto.DepartmentDto;
import com.attendance.attendance.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    //	전체조회
    @GetMapping("/dept")
    public String selectDeptList(@RequestParam(defaultValue = "") String searchKeyword,
                                 @PageableDefault(page = 0, size = 3) Pageable pageable,
                                 Model model) {
//		1) Pageable : page(현재페이지), size(1페이지 당 화면에 보일개수)
//		Pageable pageable = PageRequest.of(page, size);
//		전체조회 서비스 메소드 실행
        Page<DepartmentDto> pages = departmentService.selectDeptList(searchKeyword, pageable);
        log.info("테스트 : " + pages);
        model.addAttribute("depts", pages.getContent());
        model.addAttribute("pages", pages);

        return "dept/dept_all";
    }
}