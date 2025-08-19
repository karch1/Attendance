//package com.attendance.attendance.filedb.dto;
//
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class FileDbDto {
////    엔티티 클래스 보고 만들기 DTO에선 어노테이션은 안씀 (@Id, @Lob)
////    DTO의 필드가 화면에 보임 : 결정) 성능) 이미지는 빼기 (fileData 생략)
////                                      (왜냐 화면에 필요한 것은 다운로드URL만 있음 이미지 나옴)
//    private String uuid;                // 기본키, 자바 UUID 이용
//    private String fileTitle;
//    private String fileContent;
//    private String fileUrl;             // 화면에 이미지 보이기 URL
//
////    생성자 (매개변수 2개 : fileTitle, fileContent)
//
//    public FileDbDto(String fileTitle, String fileContent) {
//        this.fileTitle = fileTitle;
//        this.fileContent = fileContent;
//    }
//}
