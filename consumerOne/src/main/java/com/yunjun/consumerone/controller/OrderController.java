package com.yunjun.consumerone.controller;

import com.yunjun.cloudcommon.model.RestResult;
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
@RequestMapping("/order")
public class OrderController {

    private String userUrl = "http://productOne/user";
    @Autowired
    RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    public RestResult getUserByNacos(@PathVariable(value = "id") Integer id){
        return  restTemplate.getForObject(userUrl+"/info/"+id,RestResult.class,Integer.class);
    }
}
