package com.yunjun.producttwo.controller;

import com.yunjun.cloudcommon.config.rabbit.RabbitConstant;
import com.yunjun.cloudcommon.model.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @PACKAGE_NAME: com.yunjun.producttwo.controller
 * @NAME: ProducterController
 * @USER: jack
 * @DATE: 2/27/2023
 * @PROJECT_NAME: cloudParent
 **/
@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/helloSend")
    public void helloSend(String message) throws UnsupportedEncodingException {
        //设置部分请求参数
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
        rabbitTemplate.send(RabbitConstant.HELLO_QUEUE_NAME, new Message(message.getBytes("UTF-8"), messageProperties));
    }


    /**
     * 消息可靠性投递 确认模式
     * 1、在配置中开启消息投递配置项 publisher-returns: true
     * 2、设置消息投递回调函数
     */
    @GetMapping("/work")
    public void workSend(){
//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//
//            }
//        });
        /**
         * 参数说明：1 、配置拓展参数
         * 2、 ack 表示交换机是否收到消息
         * 3、 失败的原因
         */
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if(ack){
                //消息被交换机成功收到
            }else{
                //消息传递失败
            }
        });
        for (int i = 0; i <100 ; i++) {
            User user = new User(i,"testName__"+i);
            rabbitTemplate.convertAndSend(RabbitConstant.WORK_QUEUE_NAME,user);
        }
    }

    /**
     * 路由模式
     */
    @GetMapping("/direct")
    public void  directSend(){
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if(ack){
                //消息被交换机成功收到
                System.out.println("消息被发送成功！！！");
            }else{
                //消息传递失败
            }
        });
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(RabbitConstant.DIRECT_EXCHANGE_NAME,RabbitConstant.DIRECT_ROUTING_KEY_NAME,"这是direct rabbit 模式--"+i);
        }
    }

    /**
     * 广播模式
     */
    @GetMapping("/fanout")
    public void fanoutSend(){
        rabbitTemplate.convertAndSend(RabbitConstant.FANOUT_EXCHANGE_NAME,"","fanout 模式的rabbit !!!");
    }

    /**
     * 延迟队列的实现
     */
    @GetMapping("/delay")
    public  void  delaySend(){
        rabbitTemplate.convertAndSend(RabbitConstant.DELAY_CUSTOMER_EXCHANGE_NAME,RabbitConstant.DELAY_CUSTOMER_ROUTING_NAME,"这个消息将在10s后过期");
    }
}
