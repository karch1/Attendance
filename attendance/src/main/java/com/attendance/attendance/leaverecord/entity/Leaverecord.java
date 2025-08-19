package com.attendance.attendance.leaverecord.entity;

import com.attendance.attendance.employee.entity.Emp;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "LEAVERECORD")
@SequenceGenerator(
        name = "SQ_LEAVE_JPA",
        sequenceName = "SQ_LEAVE",
        allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "emp")
@EqualsAndHashCode(of = "leaveId", callSuper = false)
public class Leaverecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_LEAVE_JPA")     // JPA시퀀스이름 넣기
    private Long leaveId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")  // DB 참조키 컬럼 이름넣기
    private Emp emp;
}
