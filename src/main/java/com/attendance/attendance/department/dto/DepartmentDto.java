package com.attendance.attendance.department.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
    private Long deptId;       // 부서번호(기본키)
    private String deptName;   // 부서이름
    private String location;    // 부서위치
}
