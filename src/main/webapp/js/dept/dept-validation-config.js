/**
 *
 */ 
$("#addForm").validate({  // addForm 태그를 선택해서 유효성 검사 시작
  rules: {                // 유효성 규칙
    dname: {              // id 별명 검사 규칙 정의
      required: true,     // 필수(생략 불가)
      minlength: 2,       // 최소 입력글자가 2자 이상되게 함
    },
    loc: {
      required: true,
      minlength: 2,
    }
  },
  messages: {              // 위에서 검사 규칙을 위반했을때 화면에 보여줄 글자
    dname: {               // 글자를 보여줄 id 별명
      required: "필수 입력 항목입니다.",           // required 규칙을 위반했을 때 보여줄 글자
      minlength: "최소 {0}글자 이상 입력하세요.",  // minlength 규칙을 위반했을 때 보여줄 글자
    },
    loc: {
      required: "필수 입력 항목입니다.",
      minlength: "최소 {0}글자 이상 입력하세요.",
    }
  }
});
