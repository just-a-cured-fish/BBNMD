package com.yc.bbnmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication


@MapperScan(basePackages="sc.provider.dao")
public class DomainApp {
    public static void main(String[] args) {
        SpringApplication.run(DomainApp.class, args);
    }
}
