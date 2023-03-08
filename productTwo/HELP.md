# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/#build-image)

问题1：springboot启动不起来 Disconnected from the target VM, address: '127.0.0.1:5406', transport: 'socket' 
解决：向pom.xml文件中添加spring-boot-starter-web依赖
知识点：
死信队列： 
    消息成为死信的原因：
    1、消息队列长度达到限制
    2、消费者决绝消费消息，basicNack 或basicReject 设置了重回消息队列为false
    3、原队列存在消息过期时间设置，消息达到过期时间后未被消费