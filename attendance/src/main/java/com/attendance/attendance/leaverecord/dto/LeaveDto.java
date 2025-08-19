package com.attendance.attendance.leaverecord.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeaveDto {
    private Long leaveId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;
    private String status;

//  참조키
    private String empId;
}
