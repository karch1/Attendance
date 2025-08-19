package com.attendance.attendance.attendancerecord.entity;

import com.attendance.attendance.employee.entity.Emp;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

// JPA 어노테이션
@Entity
@Table(name = "ATTENDANCERECORD")
@SequenceGenerator(
        name = "SQ_ATT_JPA",
        sequenceName = "SQ_ATT",
        allocationSize = 1
)
@Getter
@Setter
@ToString(exclude = "emp")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "recordId", callSuper = false)
public class Attendancerecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_ATT_JPA")
    private Long recordId;
    private LocalDate attDate;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private Emp emp;

}
