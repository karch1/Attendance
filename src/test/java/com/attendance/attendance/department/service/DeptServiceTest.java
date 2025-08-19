package com.attendance.attendance.department.service;

import com.attendance.attendance.department.dto.DeptDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
@SpringBootTest
@EnableJpaAuditing
class DeptServiceTest {
    @Autowired
    DeptService deptService;

    @Test
    void selectDeptList() {
        String searchKeyword="";
        Pageable pageable = PageRequest.of(0,3);
        Page<DeptDto> page = deptService.selectDeptList(searchKeyword, pageable);
        log.info("테스트 : "+page.getContent());  // 패이지 안에 content 에 dept 객체가 있습니다.

    }
}