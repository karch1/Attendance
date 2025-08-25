package com.attendance.attendance.salary.repository;

import com.attendance.attendance.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

    List<Salary> findAllByEmp_EmpIdOrderByPayDateDesc(Long empId); // 여러 급여를 반환

    // 같은 사원 + 지급일 존재 여부 확인
    Optional<Salary> findByEmp_EmpIdAndPayDate(Long empId, LocalDate payDate);

    /**
     * 특정 사원의 연도/월별 급여 조회 (Oracle EXTRACT 함수 사용)
     *
     * @param empId 사원 ID
     * @param year  조회할 연도 (예: 2025)
     * @param month 조회할 월 (예: 8)
     * @return 해당 사원의 해당 연월 급여 목록 (최신 지급일 순 정렬)
     *
     * - nativeQuery = true → JPQL이 아닌 실제 DB의 SQL을 그대로 실행
     * - Oracle의 EXTRACT 함수를 사용하여 pay_date 컬럼에서 연도, 월을 추출
     * - ORDER BY s.pay_date DESC → 가장 최근 지급일이 위로 오도록 정렬
     */
    @Query(value = "SELECT * FROM salary s " +
            "WHERE s.emp_id = :empId " +                        // 특정 사원만 조회
            "AND EXTRACT(YEAR FROM s.pay_date) = :year " +      // 연도 조건
            "AND EXTRACT(MONTH FROM s.pay_date) = :month " +    // 월 조건
            "ORDER BY s.pay_date DESC",                         // 지급일 기준 내림차순 정렬
            nativeQuery = true)
    List<Salary> findByEmpIdAndYearAndMonth(
            @Param("empId") Long empId,
            @Param("year") int year,
            @Param("month") int month);



}
