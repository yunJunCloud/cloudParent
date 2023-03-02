package com.yunjun.consumerone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//进行包扫描
//@ComponentScan(basePackages = {"com.yunjun.cloudcommon"})
public class ConsumerOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOneApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
