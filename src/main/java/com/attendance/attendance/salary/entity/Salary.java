package com.attendance.attendance.salary.entity;

import com.attendance.attendance.employee.entity.Emp;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "SALARY",
        uniqueConstraints = @UniqueConstraint(columnNames = {"EMP_ID", "payDate"}) // 여기
)
@SequenceGenerator(
        name = "SQ_SALARY_JPA",
        sequenceName = "SQ_SALARY",
        allocationSize = 1
)
@Getter
@Setter
@ToString(exclude = "emp")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "salaryId", callSuper = false)
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_SALARY_JPA")
    private Long salaryId;

    private LocalDate payDate;
    private Long baseSalary;
    private Long bonus;
    private Long withholding;

    @Column(insertable = false, updatable = false) // DB에서 계산된 값 읽기 전용
    private Long netPay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private Emp emp;
}
