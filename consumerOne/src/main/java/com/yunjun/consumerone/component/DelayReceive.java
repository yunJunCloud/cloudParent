package com.yunjun.consumerone.component;

import com.yunjun.cloudcommon.config.rabbit.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.yunjun.consumerone.component
 * @NAME: DelayReceive
 * @USER: jack
 * @DATE: 3/1/2023
 * @PROJECT_NAME: cloudParent
 **/
@Component
@RabbitListener(queues = RabbitConstant.DELAY_CUSTOMER_DLX_QUEUE_NAME)
public class DelayReceive {

    @RabbitHandler
    public void delayDlx(String message){
        System.out.println("消息进入了死信队列中"+message);
    }
}
