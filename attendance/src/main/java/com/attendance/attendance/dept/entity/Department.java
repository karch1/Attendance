package com.attendance.attendance.dept.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Table(name = "DEPARTMENT")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "dept_Id", callSuper = false)
public class Department {
}
//DEPT_ID	NUMBER(10,0)
//DEPT_NAME	VARCHAR2(50 BYTE)
//LOCATION	VARCHAR2(50 BYTE)
