package com.yunjun.cloudcommon.config.rabbit;

public interface RabbitConstant {


    public final static  String HELLO_QUEUE_NAME = "helloQueue";

    public final static String WORK_QUEUE_NAME = "workQueue";

    public final static String FANOUT_QUEUE_ONE_NAME = "fanout.one";

    public final static String FANOUT_QUEUE_TWO_NAME = "fanout.two";

    public final static String FANOUT_EXCHANGE_NAME = "fanout.exchange";

    public final static String DIRECT_QUEUE_ONE_NAME = "direct.one";

    public final static String DIRECT_QUEUE_TWO_NAME = "direct.two";

    public final static String DIRECT_EXCHANGE_NAME = "direct.exchange";

    public final static String DIRECT_ROUTING_KEY_NAME = "direct.routing";


    public final static String TOPIC_QUEUE_ONE_NAME = "topic.one";

    public final static String TOPIC_QUEUE_TWO_NAME = "topic.two";

    public final static String TOPIC_EXCHANGE_NAME = "topic.exchange";

    public final static String TOPIC_ROUTING_KEY_ONE_NAME = "topic.routing.*";

    public final static String TOPIC_ROUTING_KEY_TWO_NAME = "#.topic.routing";


    /***
     * 正常队列
     */
    public final static String DELAY_CUSTOMER_QUEUE_NAME = "delay_customer_queue";
    public final static String DELAY_CUSTOMER_EXCHANGE_NAME = "delay_customer_exchange";
    public final static String DELAY_CUSTOMER_ROUTING_NAME = "delay_customer_routing";

    /**
     * 死信队列
     */
    public final static String DELAY_CUSTOMER_DLX_QUEUE_NAME = "delay_customer_dlx_queue";
    public final static String DELAY_CUSTOMER_DLX_EXCHANGE_NAME = "delay_customer_dlx_exchange";
    public final static String DELAY_CUSTOMER_DLX_ROUTING_NAME = "delay_customer_dlx_routing";
}
