package com.bbnmb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override   //设置网络安全配置信息
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();  //关闭csrf
        super.configure(http);
    }
}
