package com.yevhenkim.communityskillshare.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    @Bean
    public String jwtSecret() {
        return jwtSecret;
    }

    @Bean
    public int jwtExpirationInMs() {
        return jwtExpirationInMs;
    }
}