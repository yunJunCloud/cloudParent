package com.yunjun.producttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
//@ComponentScan(basePackages = "com.yunjun.cloudcommon.config.rabbit")
public class ProductTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductTwoApplication.class, args);
    }

}
