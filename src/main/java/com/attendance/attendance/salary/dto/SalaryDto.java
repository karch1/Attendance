package com.attendance.attendance.salary.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalaryDto {
    private Long salaryId;
    private LocalDate payDate;
    private Long baseSalary;
    private Long bonus;
    private Long withholding;
    private Long netPay;

    private Long empId;
    private String name;  // 사원이름 조회용
}
