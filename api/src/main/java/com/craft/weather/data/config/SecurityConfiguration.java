package com.craft.weather.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;

@Configuration
public class SecurityConfiguration implements WebSecurityConfigurer {
    @Override
    public void init(SecurityBuilder builder) throws Exception {

    }

    @Override
    public void configure(SecurityBuilder builder) throws Exception {
//        http.csrf().disable();
    }
}
