/**
 *
 */ 
$("#addForm").validate({       // addForm 태그를 선택해서 유효성 검사 시작
  rules: {                     // 유효성 규칙
    // 유효성 검사 규칙
    ename: {                   // id 별명 검사 규칙 정의
      required: true,          // 필수(생략 불가)
      minlength: 2,            // 최소 입력글자가 2자 이상되게 함
    },
    job: {
      required: true,
      minlength: 2,
    },
    manager: {
      required: true,          // 필수(생략 불가)
      digits: true,            // 숫자만 입력하게 함
    },
    hiredate: {
      required: true,
      date: true,              // 날짜만 입력하게 함(yyyy-MM-dd 형식)
    },
    salary: {
      required: true,
      digits: true,
    },
    commission: {              // null 값 들어올 수 있음: required 빼기
      digits: true,
    },
    dno: {
      required: true,
      digits: true,
    }
  },
  messages: {                   // 위에서 검사 규칙을 위반했을때 화면에 보여줄 글자
    ename: {                    // 위반 글자를 보여줄 id 별명
      required: "필수 입력 항목입니다.",         // required 규칙을 위반했을 때 보여줄 글자
      minlength: "최소 {0}글자 이상 입력하세요.", // minlength 규칙을 위반했을 때 보여줄 글자
    },
    job: {
      required: "필수 입력 항목입니다.",
      minlength: "최소 {0}글자 이상 입력하세요.",
    },    
    manager: {
      required: "필수 입력 항목입니다.",
      digits: "반드시 숫자만 입력하세요.",        // digits 규칙을 위반했을 때 보여줄 글자
    },
    hiredate: {
      required: "필수 입력 항목입니다.",
      date: "날짜 포맷(yyyy-MM-dd)만 입력하세요.",// date 규칙을 위반했을 때 보여줄 글자
    },    
    salary: {
      required: "필수 입력 항목입니다.",
      digits: "반드시 숫자만 입력하세요.",
    },
    commission: {
      digits: "반드시 숫자만 입력하세요.",
    },
    dno: {
      required: "필수 입력 항목입니다.",
      digits: "반드시 숫자만 입력하세요.",
    }
  }
});
