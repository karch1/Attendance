package com.attendance.attendance.config;

import com.attendance.attendance.employee.entity.Emp;
import com.attendance.attendance.employee.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final EmpRepository empRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Emp emp = empRepository.findById(Long.valueOf(username))
                    .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
            return User.builder()
                    .username(String.valueOf(emp.getEmpId()))
                    .password(emp.getPw()) // 암호화 필요 (BCrypt)
                    .roles(emp.getRole().replace("ROLE_", ""))
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/salary/mine").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/salary/list", "/salary/register/**").hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN") // ← /admin 접근을 ADMIN으로 제한
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler((request, response, authentication) -> {
                            // 로그인 성공 후 역할 기반 리다이렉트
                            boolean isAdmin = authentication.getAuthorities().stream()
                                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
                            if (isAdmin) {
                                response.sendRedirect("/admin");
                            } else {
                                response.sendRedirect("/"); // 일반 사용자
                            }
                        })
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }

}
