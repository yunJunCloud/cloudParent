package com.example.yunjunspringbootstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @PACKAGE_NAME: com.example.yunjunspringbootstarter.config
 * @NAME: UserProperties
 * @USER: jack
 * @DATE: 3/6/2023
 * @PROJECT_NAME: cloudParent
 **/
@ConfigurationProperties(prefix = UserProperties.USER_PREFIX)
@Data
public class UserProperties {

    public static final String USER_PREFIX = "spring.user";

    private String testName= "张三";

    private String testPassWord = "password";
}
