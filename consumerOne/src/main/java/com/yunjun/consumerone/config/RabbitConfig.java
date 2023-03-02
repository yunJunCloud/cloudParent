package com.yunjun.consumerone.config;

import com.yunjun.cloudcommon.config.rabbit.RabbitConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * @PACKAGE_NAME: com.yunjun.producttwo.config.rabbit
 * @NAME: HelloWorldConfig
 * @USER: jack
 * @DATE: 2/27/2023
 * @PROJECT_NAME: cloudParent
 **/
@Configuration
public class RabbitConfig {

    /**
     * HelloWorld rabbitmq第一个工作模式
     * 直连模式只需要声明队列，所有消息都通过队列转发。
     * 无需设置交换机
     */
    @Bean
    public Queue setQueue() {
        return new Queue(RabbitConstant.HELLO_QUEUE_NAME);
    }

    /**
     * 工作模式
     * 一个生产者对应多个消费者
     * @return
     */
    @Bean
    public Queue workQ1() {
        return new Queue(RabbitConstant.WORK_QUEUE_NAME);
    }

    /**
     * 订阅模型-Fanout也成为广播模式，流程如下
     * 1.可以有多个消费者
     * 2.每个消费者有自己的队列
     * 3. 每个队列都要绑定到Exchange（交换机）
     * 4. 生产者发送的消息，只能发送到交换机，交换机来决定要发给哪个队列，生产者无法决定。
     * 5. 交换机把消息发送给绑定过的所有队列
     * 6. 队列的消费者都能拿到消息。实现一条消息被多个消费者消费
     */
    @Configuration
    class  FanoutConfig{
        //声明队列
        @Bean
        public Queue fanoutOne() {
            return new Queue(RabbitConstant.FANOUT_QUEUE_ONE_NAME);
        }
        @Bean
        public Queue fanoutTwo() {
            return new Queue(RabbitConstant.FANOUT_QUEUE_TWO_NAME);
        }


        //声明exchange
        @Bean
        public FanoutExchange setFanoutExchange() {
            return new FanoutExchange(RabbitConstant.FANOUT_EXCHANGE_NAME);
        }


        //声明Binding,exchange与queue的绑定关系
        @Bean
        public Binding bindOne() {
            return BindingBuilder.bind(fanoutOne()).to(setFanoutExchange());
        }
        @Bean
        public Binding bindTwo() {
            return BindingBuilder.bind(fanoutTwo()).to(setFanoutExchange());
        }
    }


    /**
     *订阅模型-Direct (路由模式)
     * 在Fanout模式中，一条消息，会被所有订阅的队列都消费。但是，在某些场景下，我们希望不同的消息被不同的队列消费。这时就要用到Direct类型的Exchange。给特定的消费者消费
     * 在Direct模型下：
     *
     * 1.队列与交换机的绑定，不能是任意绑定了，而是要指定一个RoutingKey（路由key）
     * 2.消息的发送方在 向 Exchange发送消息时，也必须指定消息的 RoutingKey。
     * 3.Exchange不再把消息交给每一个绑定的队列，而是根据消息的Routing Key进行判断，只有队列的 Routingkey与消息的 Routing key完全一致，才会接收到消息
     * 总体来说：就是按照一个Exchange 按照一定的规则 分发到不通的队列里面
     */
    @Configuration
    class DirectConfig {

        //声明队列
        @Bean
        public Queue directOne() {
            return new Queue(RabbitConstant.DIRECT_QUEUE_ONE_NAME);
        }
        @Bean
        public Queue directTwo() {
            return new Queue(RabbitConstant.DIRECT_QUEUE_TWO_NAME);
        }


        //声明exchange
        @Bean
        public DirectExchange setDirectExchange() {
            return new DirectExchange(RabbitConstant.DIRECT_EXCHANGE_NAME);
        }

        //声明binding，需要声明一个routingKey
        @Bean
        public Binding bindDirectBindOne() {
            return BindingBuilder.bind(directOne()).to(setDirectExchange()).with(RabbitConstant.DIRECT_ROUTING_KEY_NAME);
        }
        @Bean
        public Binding bindDirectBindTwo() {
            return BindingBuilder.bind(directTwo()).to(setDirectExchange()).with(RabbitConstant.DIRECT_ROUTING_KEY_NAME);
        }

    }

    /**
     * 订阅模型-Topic (主题模式)
     * Topic类型的Exchange与Direct相比，都是可以根据RoutingKey把消息路由到不同的队列。只不过Topic类型Exchange可以让队列在绑定Routing key 的时候使用通配符！
     */
    @Configuration
    class TopicConfig {

        //声明队列
        @Bean
        public Queue topicQ1() {
            return new Queue(RabbitConstant.TOPIC_QUEUE_ONE_NAME);
        }
        @Bean
        public Queue topicQ2() {
            return new Queue(RabbitConstant.TOPIC_QUEUE_TWO_NAME);
        }


        //声明exchange
        @Bean
        public TopicExchange setTopicExchange() {
            return new TopicExchange(RabbitConstant.TOPIC_EXCHANGE_NAME);
        }

        //声明binding，需要声明一个roytingKey
        @Bean
        public Binding bindTopicHebei1() {
            return BindingBuilder.bind(topicQ1()).to(setTopicExchange()).with(RabbitConstant.TOPIC_ROUTING_KEY_ONE_NAME);
        }
        @Bean
        public Binding bindTopicHebei2() {
            return BindingBuilder.bind(topicQ2()).to(setTopicExchange()).with(RabbitConstant.TOPIC_ROUTING_KEY_TWO_NAME);
        }

    }


    class Delay {
        /***
         * 延迟队列
         * 1、定义正常队列 设置过去时间
         * 2、定义死信队列
         * 3、正常队列绑定私信队列
         */

        @Bean
        public Queue delayQueue() {
            Map<String, Object> args = new HashMap<>();
            //设置消息过期时间
            args.put("x-message-ttl", 1000 * 10);
            //设置死信交换机
            args.put("x-dead-letter-exchange", RabbitConstant.DELAY_CUSTOMER_DLX_EXCHANGE_NAME);
            //设置死信 routing_key
            args.put("x-dead-letter-routing-key", RabbitConstant.DELAY_CUSTOMER_DLX_ROUTING_NAME);
            return new Queue(RabbitConstant.DELAY_CUSTOMER_QUEUE_NAME, true, false, false, args);
        }

        @Bean
        public DirectExchange delayExchange(){
            return new DirectExchange(RabbitConstant.DELAY_CUSTOMER_EXCHANGE_NAME);
        }

        @Bean
        public Binding delayBinding(){
            return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(RabbitConstant.DELAY_CUSTOMER_ROUTING_NAME);
        }

        @Bean
        public Queue delayDlxQueue(){
            return new Queue(RabbitConstant.DELAY_CUSTOMER_DLX_QUEUE_NAME);
        }

        @Bean
        public Exchange delayDlxExchange(){
            return new DirectExchange(RabbitConstant.DELAY_CUSTOMER_DLX_EXCHANGE_NAME);
        }

        @Bean
        public Binding delayDlxBinding(){
            return BindingBuilder.bind(delayDlxQueue()).to(delayDlxExchange()).with(RabbitConstant.DELAY_CUSTOMER_DLX_ROUTING_NAME).noargs();
        }
    }
}
