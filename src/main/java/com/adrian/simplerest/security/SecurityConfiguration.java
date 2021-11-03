package com.adrian.simplerest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/m1")
                .hasAnyRole("R1", "R2", "R3")
                .mvcMatchers(HttpMethod.GET, "/m2")
                .hasAnyRole("R2", "R3")
                .mvcMatchers(HttpMethod.GET, "/m3")
                .hasAnyRole("R3")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user_m1").password("user_m1").roles("R1");
        auth.inMemoryAuthentication().withUser("user_m2").password("user_m2").roles("R2");
        auth.inMemoryAuthentication().withUser("user_m3").password("user_m3").roles("R3");
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
