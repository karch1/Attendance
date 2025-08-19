//package com.attendance.attendance.filedb.entity;
//
//import com.simplecoding.simpledms.common.BaseTimeEntity;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Lob;
//import jakarta.persistence.Table;
//import lombok.*;
//
////  JPA 어노테이션
//@Entity
//@Table(name = "TB_FILE_DB")
////  롬북 어노테이션
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode(of = "uuid", callSuper = false)
//public class FileDb extends BaseTimeEntity {
////    TB_FILE_DB 테이블 보고 만들기
//    @Id
//    private String uuid;                // 기본키, 자바 UUID 이용
//    private String fileTitle;
//    private String fileContent;
//    @Lob                                // DB 자료형이 BLOB 일경우 붙이는 어노테이션
//    private byte[] fileData;            // 업로드 이미지(DB 저장, BLOB 자료형)
//    private String fileUrl;             // 이미지 다운로드 URL(img 태그 사용)
//}
