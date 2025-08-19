package com.attendance.attendance.attendanceRecord.entity;

import jakarta.persistence.*; // JPA 관련 어노테이션
import lombok.*; // Getter, Setter, Constructor 등 자동 생성
import java.time.LocalDate; // 날짜 타입
import java.time.LocalTime; // 시간 타입

// ================= 엔티티 선언 =================
// JPA에서 이 클래스가 DB 테이블과 매핑됨을 의미
@Entity

// 매핑할 테이블 이름 지정
@Table(name = "ATTENDANCERECORD")

// ================= Lombok 어노테이션 =================
// Getter / Setter 자동 생성
@Getter
@Setter

// 기본 생성자 자동 생성
@NoArgsConstructor

// 모든 필드를 매개변수로 받는 생성자 자동 생성
@AllArgsConstructor

// toString() 메소드 자동 생성 (객체 내용 확인용)
@ToString

// equals()와 hashCode() 자동 생성
// 기본키 recordId만 사용
@EqualsAndHashCode(of = "recordId")
public class AttendanceRecord {

    // ================= 필드 =================

    // 출퇴근 기록 고유 ID (기본키)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 증가
    @Column(name = "RECORD_ID")
    private Long recordId;

    // 직원 ID (EMPLOYEE 테이블 참조)
    @Column(name = "EMP_ID", nullable = false)
    private String empId;

    // 출근/퇴근 날짜
    @Column(name = "ATT_DATE", nullable = false)
    private LocalDate attDate;

    // 출근 시간
    @Column(name = "CLOCK_IN_TIME")
    private LocalTime clockInTime;

    // 퇴근 시간
    @Column(name = "CLOCK_OUT_TIME")
    private LocalTime clockOutTime;
}