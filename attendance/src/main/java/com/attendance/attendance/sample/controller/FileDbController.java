//package com.attendance.attendance.filedb.controller;
//
//import com.simplecoding.simpledms.filedb.dto.FileDbDto;
//import com.simplecoding.simpledms.filedb.entity.FileDb;
//import com.simplecoding.simpledms.filedb.repository.FileDbRepository;
//import com.simplecoding.simpledms.filedb.service.FileDbService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//@Controller
//@Log4j2
//@RequiredArgsConstructor
//public class FileDbController {
//    //    생성자 DI
//    private final FileDbService fileDbService;
//    private final FileDbRepository fileDbRepository;
//
//    //    전체조회: (페이징: 매개변수(Pageable), 결과(Page))
////     TODO: 현재페이지번호(page), 화면에보일개수(size)
////      @PageableDefault(page = 0, size = 3) : jsp에서 값을 보내지 않을 경우 기본값으로 0,3을 사용하겠다는 의미
////    쿼리스트링: @RequestParam()
//    @GetMapping("/fileDb")
//    public String selectFileDbList(@RequestParam(defaultValue = "") String searchKeyword,
//                                   @PageableDefault(page = 0, size = 3) Pageable pageable,
//                                   Model model) {
////        1) 전체 조회
//        Page<FileDbDto> pages = fileDbService.selectFileDbList(searchKeyword, pageable);
////        로깅
//        log.info(pages.getContent()); // 배열 결과 확인
////        2) jsp 로 전달: Model 사용
//        model.addAttribute("fileDbs", pages.getContent()); // 부서 배열
//        model.addAttribute("pages", pages);                // 페이지 정보(현재페이지번호, 총건수 등)
//
//        return "fileDb/fileDb_all";
//    }
//
//    //    추가 페이지 열기
//    @GetMapping("/fileDb/addition")
//    public String createFileDbView() {
//        return "fileDb/add_fileDb";
//    }
//
//    //    저장
//    @PostMapping("/fileDb/add")
//    public String insert(@RequestParam(defaultValue = "") String fileTitle,
//                         @RequestParam(defaultValue = "") String fileContent,
//                         @RequestParam(required = false) MultipartFile image) throws Exception {
////        1) FileDbDto 생성자에 값 넣기
//        FileDbDto fileDbDto = new FileDbDto(fileTitle, fileContent);
////        2) 서비스의 저장함수 실행
//        fileDbService.save(fileDbDto, image.getBytes());
//
//        return "redirect:/fileDb";
//    }
//
//    //  다운로드 메소드 : 이것이 있어야 화면에 이미지가 보임
////    ResponseBody : 데이터 + 신호를 같이 보낼 수 있음(프론트로)
////    신호 : OK(200), NOT_FOUND(404)
////    200번대 신호 : 거의 성공 신호
////    404(페이지없음), 403,401(인증,권한이 없음),(대체로 프론트쪽 살펴보기)
////    50X번대 신호 : 벡엔드에러들(자바쪽 살펴보기)
////    DB 컬럼(fileUrl) : ~/fileDb/download/uuid값 을 이미지 태그에 넣으면 이 함수가 실행됨
//    @GetMapping("/fileDb/download")
//    @ResponseBody
//    public ResponseEntity<byte[]> fileDownload(@RequestParam(defaultValue = "") String uuid) {
////        1) 상세조회 : 이미지를 가져오기 위해
//        FileDb fileDb = fileDbService.findById(uuid);
////        2) 이미지(택배) : 헤더에 이미지 보낸다고 알리고 보내기
//        HttpHeaders headers = new HttpHeaders();
////        3) 첨부파일 보낸다 의미 넣기
////        사용법 : 변수.setContentDispositionFormData("attachment(이건고정임)", "파일명");
//        headers.setContentDispositionFormData("attachment", fileDb.getUuid());
////        4) 첨부파일 문서형식(이진파일) 의미 넣기 :
////        이진파일 의미 : MediaType.APPLICATION_OCTET_STREAM
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
////        HttpStatus.OK : 200번 성공 신호
//        return new ResponseEntity<byte[]>(fileDb.getFileData(),
//                headers, HttpStatus.OK);
//    }
//
////    삭제
//    @PostMapping("/fileDb/delete")
//    public String deleteById(@RequestParam(defaultValue = "") String uuid) {
////        서비스의 삭제 함수 실행
//        fileDbService.deleteById(uuid);
//        return "redirect:/fileDb";
//    }
//}
