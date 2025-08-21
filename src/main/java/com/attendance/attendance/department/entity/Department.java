package com.attendance.attendance.department.entity;

import com.attendance.attendance.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "DEPARTMENT")
@SequenceGenerator(
        name = "SQ_DEPARTMENT_JPA",
        sequenceName = "SQ_DEPARTMENT",
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "deptId", callSuper = false)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_DEPARTMENT_JPA"
    )
    private Long deptId;       // 부서번호(기본키)
    private String deptName;   // 부서이름
    private String location;    // 부서위치

}

