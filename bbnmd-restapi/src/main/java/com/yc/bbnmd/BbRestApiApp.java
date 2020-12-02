package com.yc.bbnmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableEurekaClient    //启动eureka客户端
@EnableCircuitBreaker   //启用断路器
@SpringCloudApplication
public class BbRestApiApp {
    public static void main(String[] args) {
        SpringApplication.run(BbRestApiApp.class, args);
    }
}
