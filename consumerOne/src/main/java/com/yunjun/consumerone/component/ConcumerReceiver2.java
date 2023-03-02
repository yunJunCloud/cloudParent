package com.yunjun.consumerone.component;

import com.rabbitmq.client.Channel;
import com.yunjun.cloudcommon.config.rabbit.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @PACKAGE_NAME: com.yunjun.consumerone.component
 * @NAME: ConcumerReceiver2
 * @USER: jack
 * @DATE: 2/28/2023
 * @PROJECT_NAME: cloudParent
 **/
@Component
@RabbitListener(queues = RabbitConstant.DIRECT_QUEUE_ONE_NAME)
public class ConcumerReceiver2 {

    @RabbitHandler
    public void directOne(String message, Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("directOne----"+message);
        try {
            Thread.sleep(1000);
            //int a= 3/0;
            //手动签收
            //channel.basicAck(tag,true);
        }catch (Exception e){
            //第三个参数表示 处理失败后重回queue
            channel.basicNack(tag,true,true);
        }
    }
}
