package com.attendance.attendance.dept.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
    private Long dept_Id;       // 부서번호(기본키)
    private String dept_Name;   // 부서이름
    private String location;    // 부서위치
}
