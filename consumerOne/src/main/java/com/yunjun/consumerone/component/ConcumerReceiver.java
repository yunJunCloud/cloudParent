package com.yunjun.consumerone.component;

import cn.hutool.core.util.HashUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONConverter;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rabbitmq.client.Channel;
import com.yunjun.cloudcommon.config.rabbit.RabbitConstant;
import com.yunjun.cloudcommon.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @PACKAGE_NAME: com.yunjun.consumerone.component
 * @NAME: ConcumerReceiver
 * @USER: jack
 * @DATE: 2/27/2023
 * @PROJECT_NAME: cloudParent
 **/
@Component
public class ConcumerReceiver {

    /***
     * 1.@RabbitListener 注解是指定某方法作为消息消费的方法，例如监听某 Queue 里面的消息。
     *
     * 2.@RabbitListener标注在方法上，直接监听指定的队列，此时接收的参数需要与发送市类型一致
     * @param message
     */

    @RabbitListener(queues = RabbitConstant.HELLO_QUEUE_NAME)
    public void helloReceiver(String message){
        System.out.println("helloWorld模式 received message : " + message);
    }

    @RabbitListener(queues = RabbitConstant.WORK_QUEUE_NAME)
    public void workReceiver1(User message){
        //JSONObject jsonObject = JSONUtil.parseObj(message);
       // User user = JSONUtil.toBean(message, User.class);
        try {
            Thread.sleep(10);
        }catch (Exception e){

        }

        System.out.println("workReceiver1----"+message.toString());
    }

    /**
     * 接收的参数需要与发送时消息的参数类型一致
     * @param message
     */
    @RabbitListener(queues = RabbitConstant.WORK_QUEUE_NAME)
    public void workReceiver2(User message){
        //JSONObject jsonObject = JSONUtil.parseObj(message);
       // User user = JSONUtil.toBean(message, User.class);
        try {
            Thread.sleep(60);
        }catch (Exception e){

        }
        System.out.println("workReceiver2----"+message.toString());
    }

    @RabbitListener(queues = RabbitConstant.DIRECT_QUEUE_TWO_NAME)
    public void directTwo(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("directTwo----"+message);
        try {
            //channel.basicAck(tag,true);
        }catch (Exception e){
            channel.basicNack(tag,true,true);
           // channel.basicReject();
        }
    }
}
