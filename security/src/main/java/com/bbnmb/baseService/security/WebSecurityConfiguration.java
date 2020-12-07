package com.bbnmb.baseService.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override   //用户名，密码，角色
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("root")
                .password(new BCryptPasswordEncoder().encode("a"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("a"))
                .roles("USER", "ADMIN");
    }

    @Override   //  资源
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().anyRequest()
                .fullyAuthenticated();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override   //对于  hystrix的仪表盘，不做处理
    public void configure(WebSecurity web) throws Exception {
        //   book是权限       user不要权限
        //   不管是什么服务，只要是访问这个服务中的  "/actuator/hystrix.stream", "/turbine.stream",不用加权限验证
        web.ignoring().antMatchers("/actuator/hystrix.stream", "/turbine.stream");
    }

}
