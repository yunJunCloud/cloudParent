package com.example.yunjunspringbootstarter.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PACKAGE_NAME: com.example.yunjunspringbootstarter.config
 * @NAME: UserAutoConfiguration
 * @USER: jack
 * @DATE: 3/6/2023
 * @PROJECT_NAME: cloudParent
 **/
@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class UserAutoConfiguration {

    private  UserProperties userProperties;
    public UserAutoConfiguration(UserProperties userProperties){
        this.userProperties = userProperties;
    }

    @Bean(name = "userAService")
    public UserAutoService userAutoService(){
        return new UserAutoService(userProperties);
    }
}
