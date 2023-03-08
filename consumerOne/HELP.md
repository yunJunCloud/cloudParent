# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/#build-image)
* 问题：A component required a bean of type ‘org.springframework.web.client.RestTemplate’ that could not be found.
* 解决方案： 在 Spring Boot 1.3版本中，会默认提供一个RestTemplate的实例Bean，而在 Spring Boot 1.4以及以后的版本中，这个默认的bean不再提供了，我们需要在Application启动时，手动创建一个RestTemplate的配置。
* 问题2： java.net.UnknownHostException: productOne
* 解决方案：pom.xml文件引入 @LoadBalanced注解的依赖
* 问题3：在接受消息时，接受消息失败
* 解决方案： 接收的参数需要与发送时消息的参数类型一致
* 问题4：项目启动成功后，访问接口一直404
* 原因：是可以单独使用@ComponentScan注解扫描第三方包,但是这里一定要注意
* @SpringBootApplication注解等价于默认属性使用@Configuration+@EnableAutoConfiguration+@ComponentScan,
* 如果@SpringBootApplication和@ComponentScan注解同时存在，
* 那么@SpringBootApplication注解中@ComponentScan的扫描范围会被覆盖,
* 所以单独使用@ComponentScan的话,必须在该注解上配置项目需要扫描的包的所有范围,即项目包路径+依赖包路径.
* 因为我引入了第三方starter 并且不在同一包下，第一次未加@ComponentScan导致自定义包中注入的bean对象未被找到
* 加入@ComponentScan注解之后，只添加了自定义starter的包名，未加自己项目的包名，导致本包下住的的bean未被发现，请求接口404
