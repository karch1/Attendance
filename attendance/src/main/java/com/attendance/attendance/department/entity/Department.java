package com.attendance.attendance.department.entity;

import jakarta.persistence.*;
import lombok.*;

// JPA 어노테이션
@Entity
@Table(name = "DEPARTMENT")
@SequenceGenerator(
        name = "SQ_DEPARTMENT_JPA",
        sequenceName = "SQ_DEPARTMENT",
        allocationSize = 1
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "deptId", callSuper = false)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_DEPARTMENT_JPA")     // JPA시퀀스이름 넣기
    private Long deptId;
    private String deptName;
    private String location;
}
