package com.sai.rise.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class security {

    @Bean
    public SecurityFilterChain sfc(HttpSecurity hs)
            throws Exception {

        return hs
                .csrf(x -> x.disable())

                .authorizeHttpRequests(request -> request

                        .requestMatchers("/home/register")
                        .permitAll()

                        .anyRequest()
                        .authenticated()
                )
               // .oauth2Client(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                //.formLogin(Customizer.withDefaults())

                //.httpBasic(Customizer.withDefaults())
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .sessionManagement(session -> session
//                        .maximumSessions(2)
//                        .maxSessionsPreventsLogin(false)
//                )

                .build();
    }


}