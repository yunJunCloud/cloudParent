package com.example.yunjunspringbootstarter.config;

/**
 * @PACKAGE_NAME: com.example.yunjunspringbootstarter.config
 * @NAME: UserAutoService
 * @USER: jack
 * @DATE: 3/6/2023
 * @PROJECT_NAME: cloudParent
 **/
public class UserAutoService {
    public UserProperties userProperties;

    public UserAutoService(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public boolean test(){
        if(userProperties.getTestName().equals("张三") && userProperties.getTestPassWord().equals("111") ){
            return true;
        }
        return false;
    }
}
