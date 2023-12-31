package com.digitalhouse.msgateway.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity server) {
        server
                .authorizeExchange(authorize -> authorize
                        .anyExchange().authenticated())
                .oauth2Login();
        return server.build();
    }
}
