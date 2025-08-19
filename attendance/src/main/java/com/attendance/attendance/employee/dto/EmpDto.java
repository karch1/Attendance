package com.attendance.attendance.employee.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpDto {
    private String empId;
    private String name;
    private String gender;
    private String phone;
    private String pw;
    private String role;

//  참조키
    private Long deptId;
}
