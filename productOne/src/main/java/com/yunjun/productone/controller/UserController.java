package com.yunjun.productone.controller;

import com.yunjun.cloudcommon.model.RestResult;
import com.yunjun.cloudcommon.model.RestResultUtils;
import com.yunjun.productone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @PACKAGE_NAME: com.yunjun.productone.controller
 * @NAME: UserController
 * @USER: jack
 * @DATE: 2/26/2023
 * @PROJECT_NAME: cloudParent
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/info/{id}")
    public RestResult getUser(@PathVariable(value = "id") Integer id){
        return RestResultUtils.success(userService.getUserById(id));
    }
}
