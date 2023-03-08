package com.yunjun.consumerone.controller;

import com.example.yunjunspringbootstarter.config.UserAutoService;
import com.yunjun.cloudcommon.exception.CommonEum;
import com.yunjun.cloudcommon.exception.YunJunException;
import com.yunjun.cloudcommon.model.RestResult;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @PACKAGE_NAME: com.yunjun.consumerone.controller
 * @NAME: OrderController
 * @USER: jack
 * @DATE: 2/27/2023
 * @PROJECT_NAME: cloudParent
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    private String userUrl = "http://productOne/user";

    private String redisServiceUrl = "http://productRedis/redis";
    @Autowired
    RestTemplate restTemplate;

    @Resource
    UserAutoService userAutoService;

    @ResponseBody
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    public RestResult getUserByNacos(@PathVariable(value = "id") Integer id){
        return  restTemplate.getForObject(userUrl+"/info/"+id,RestResult.class,Integer.class);
    }

    @GetMapping(value = "/testRedis")
    public void testReduct(){
        restTemplate.getForObject(redisServiceUrl+"/reduce3",String.class);
    }

    @GetMapping(value = "/test")
    public void  testStart(){
        boolean test = userAutoService.test();
        System.out.println(test);
    }

    @GetMapping(value = "/testNull")
    public void  testNullException(){
        String a = null;
        System.out.println(a.equals("121212"));
    }

    @GetMapping(value = "/testYunJun")
    public void  testYunJunException(){
        String a = null;
        if(null == a){
            throw  new YunJunException(CommonEum.INTERNAL_SERVER_ERROR);
        }
    }
}
