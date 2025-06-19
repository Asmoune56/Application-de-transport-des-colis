package com.example.transportplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ تعطيل الحماية من CSRF مؤقتاً
                .cors(cors -> cors.disable()) // ✅ تعطيل CORS مؤقتاً (يمكن تحسينه لاحقًا)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/dashboard/**", "/api/users/**", "/api/**").permitAll() // ✅ السماح بالوصول لهذه الروابط
                        .anyRequest().permitAll() // للسماح لكل الروابط مؤقتًا
                );

        return http.build();
    }
}
