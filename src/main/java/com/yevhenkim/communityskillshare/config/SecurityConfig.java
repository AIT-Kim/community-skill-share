package com.yevhenkim.communityskillshare.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .authorizeRequests((matchers) -> matchers
                                .requestMatchers("/","/home","/api/public/**").permitAll()
                                .requestMatchers("/", "/greeting","/home", "/index.html", "/css/**", "/js/**", "/images/**").permitAll()
                                .requestMatchers("/admin/secret").authenticated()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/secret").authenticated()
                                .anyRequest().authenticated()
                )
                /*
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )

                 */
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
