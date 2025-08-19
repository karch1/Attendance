package com.attendance.attendance.salary.dto;

import lombok.*;

import java.time.LocalDate;
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
}
