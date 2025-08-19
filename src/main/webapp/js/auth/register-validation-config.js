/**
 *
 */
$("#addForm").validate({  // addForm 태그를 선택해서 유효성 검사 시작
    rules: {                // 유효성 규칙
        email: {              // id 별명 검사 규칙 정의
            required: true,     // 필수(생략 불가)
            email: true,        // 이메일 형식 검증
        },
        password: {
            required: true,     // 필수
            minlength: 6,       // 최소글자수
        },
        repassword: {
            required: true,     // 필수
            minlength: 6,       // 최소글자수
            equalTo: password, // 비밀번호 필드와 동일한 값을 가지도록
        },
        name: {
            required: true,     // 필수
            minlength: 2,       // 최소글자수

        },
    },
    messages: {              // 위에서 검사 규칙을 위반했을때 화면에 보여줄 글자
        email: {               // 글자를 보여줄 id 별명
            required: "필수 입력 항목입니다.",           // required 규칙을 위반했을 때 보여줄 글자
            email: "올바른 이메일 형식으로 입력하세요",    // email 규칙을 위반했을 때 보여줄 글자
        },
        password: {
            required: "필수 입력 항목입니다.",
            minlength: "최소 {0}글자 이상 입력하세요.",
        },
        repassword: {
            required: "필수 입력 항목입니다.",
            minlength: "최소 {0}글자 이상 입력하세요.",
            equalTo: "동일한 비밀번호를 입력해 주세요.",
        },
        name: {
            required: "필수 입력 항목입니다.",
            minlength: "최소 {0}글자 이상 입력하세요."
        }
    }
});
