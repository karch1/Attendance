package com.attendance.attendance.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.encode("1234"));       // 테스트-인사부사원
        System.out.println(encoder.encode("1234"));       // 관리자
        System.out.println(encoder.encode("1234567890")); // 이진수
    }
}
