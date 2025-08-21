package com.attendance.attendance.employee.entity;

import com.attendance.attendance.department.entity.Department;
import jakarta.persistence.*;
import lombok.*;

// JPA 어노테이션
@Entity
@Table(name = "EMPLOYEE")
@SequenceGenerator(
        name = "SQ_EMP_JPA",
        sequenceName = "SQ_EMP",
        allocationSize = 1
)
@Getter
@Setter
@ToString(exclude = "dept")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "empId", callSuper = false)
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_EMP_JPA")     // JPA시퀀스이름 넣기
    private Long empId;    // Long으로 통일
    private String name;
    private String gender;
    private String phone;
    private String pw;
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID")  // DB 참조키 컬럼 이름넣기
    private Department dept;

}
