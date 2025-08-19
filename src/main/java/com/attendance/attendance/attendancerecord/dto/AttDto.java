package com.attendance.attendance.attendancerecord.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttDto {

    private Long recordId;
    private LocalDate attDate;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
//    참조키
    private Long empId;
}
