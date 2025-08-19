//package com.attendance.attendance.filedb.repository;
//
//import com.simplecoding.simpledms.filedb.entity.FileDb;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
////  상속 사용법 : 인터페이스명 extends JpaRepository<엔티티명, 기본키자료형>
//@Repository
//public interface FileDbRepository extends JpaRepository<FileDb, String> {
////    TODO: like 검색은 기본메소드에 없음, 직접 작성하기
////    TODO: 달라지는 점(sql->jpql): (1) *       -> 엔티티 별명
////                                (2) 테이블명 -> 엔티티 클래스명(대소문자 구분)
////                                (3) 컬럼명   -> 엔티티 필드명
////                                (4) 기타 select, from 등은 동일하게 코딩
////                                 (대소문자 구분: 엔티티명, 필드명(자바에 해당되는것들)
////                                (5) sql 함수 == jpql 함수명과 거의 비슷
//    @Query(value = "select f from FileDb f\n" +
//            "where f.fileTitle like %:searchKeyword%")
//    Page<FileDb> selectFileDbList(@Param("searchKeyword") String searchKeyword,
//                              Pageable pageable);
//}
//
//
