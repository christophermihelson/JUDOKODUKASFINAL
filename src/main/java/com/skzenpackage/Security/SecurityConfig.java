package com.skzenpackage.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception { //autoriseeri päringud üle http

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/public/**").permitAll()
                .and()
                .csrf().disable();

                //.and()
                //.addFilterBefore(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
    }

    @Bean //annotatsioon, millega saab luua beani
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
