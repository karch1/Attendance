package com.attendance.attendance.department.controller;

import com.attendance.attendance.department.dto.DepartmentDto;
import com.attendance.attendance.department.repository.DepartmentRepository;
import com.attendance.attendance.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

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

    //	추가 페이지 열기
    @GetMapping("/dept/addition")
    public String createDeptView() {
        return "dept/add_dept";
    }

    //	insert : 저장 버튼 클릭시
    @PostMapping("/dept/add")
    public String insert(@ModelAttribute DepartmentDto departmentDto) {
//		Dept 내용 확인
        log.info("테스트3 :" + departmentDto);
//		서비스의 insert 실행
        departmentService.save(departmentDto);

        return "redirect:/dept";
    }

    //	수정페이지 열기(상세조회)
    @GetMapping("/dept/edition")
    public String updateDeptView(@RequestParam long deptId, Model model) {
//		서비스의 상세조회
        DepartmentDto deptDto = departmentService.findById(deptId);
        model.addAttribute("dept", deptDto);
        return "dept/update_dept";
    }

    //	수정: 버튼 클릭시 실행
    @PostMapping("/dept/edit")
    public String update(@ModelAttribute DepartmentDto departmentDto) {
//		서비스의 수정 실행
        departmentService.updateFromDto(departmentDto);
        return "redirect:/dept";
    }
    //	삭제
    @PostMapping("/dept/delete")
    public String deleteById(@RequestParam long deptId){
//		서비스의 삭제 실행
        departmentService.deleteById(deptId);
        return "redirect:/dept";
    }
}
