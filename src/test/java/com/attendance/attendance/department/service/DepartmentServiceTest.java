package com.attendance.attendance.department.service;

import com.attendance.attendance.department.dto.DepartmentDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
@SpringBootTest
@EnableJpaAuditing
class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;
    @Test
    void save() {
//		1) 테스트 조건: Department(DEPT_ID,DEPT_NAME,LOCATION)
        DepartmentDto deptDto=new DepartmentDto();
        deptDto.setDeptName("개발부2");
        deptDto.setLocation("서울");
//		2) 실제 메소드실행
        departmentService.save(deptDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }

    @Test
    void findById() {
//		1) 테스트 조건: Dept(deptId,deptName,location)
        long deptId=30;
//		2) 실제 메소드실행
        DepartmentDto deptDto=departmentService.findById(deptId);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
        log.info(deptDto);
    }

    @Test
    void updateFromDto() {
        //		1) 테스트 조건: Dept(dno,dname,loc)
        DepartmentDto deptDto=new DepartmentDto((long)30,"개발부2","서울");
//		2) 실제 메소드실행
        departmentService.updateFromDto(deptDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }
}