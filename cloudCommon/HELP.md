# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/#build-image)

*问题1：maven打包错误: Unable to find main class  多模块打包时，由于存在没有main函数的问题，因此需要父项目的pom文件的该插件注释调就行了