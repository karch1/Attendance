package com.attendance.attendance.department.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeptDto {
    private Long deptId;
    private String deptName;
    private String location;
}
