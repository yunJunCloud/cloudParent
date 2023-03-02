package com.yunjun.consumerone.component;

import com.yunjun.cloudcommon.config.rabbit.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.yunjun.consumerone.component
 * @NAME: ConcumerFanoutReceiver
 * @USER: jack
 * @DATE: 3/1/2023
 * @PROJECT_NAME: cloudParent
 **/
@Component
public class ConcumerFanoutReceiver {

    @RabbitListener(queues = RabbitConstant.FANOUT_QUEUE_ONE_NAME)
    public void fanoutOne(String message){
        System.out.println("fanoutOne-----"+message);
    }

    @RabbitListener(queues = RabbitConstant.FANOUT_QUEUE_TWO_NAME)
    public void fanoutTwo(String message){
        System.out.println("fanoutTwo-----"+message);
    }
}
