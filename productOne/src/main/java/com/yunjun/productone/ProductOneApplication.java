package com.yunjun.productone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yunjun.productone.mapper")
public class ProductOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductOneApplication.class, args);
    }

}
