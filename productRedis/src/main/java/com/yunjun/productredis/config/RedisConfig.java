package com.yunjun.productredis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @PACKAGE_NAME: com.yunjun.productredis.config
 * @NAME: RedisConfig
 * @USER: jack
 * @DATE: 3/5/2023
 * @PROJECT_NAME: cloudParent
 **/
@Configuration
public class RedisConfig {
    /**
     * 默认是JDK的序列化策略，这里配置redisTemplate采用的是Jackson2JsonRedisSerializer的序列化策略
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会抛出异常
        om.activateDefaultTyping( LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL);
        //om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(om,Object.class);
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 配置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        // 值采用json序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /***
     * stringRedisTemplate默认采用的是String的序列化策略
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.password}")
    private String password;

    @Value("${spring.data.redis.port}")
    private int port = 6379;

    /**
     * 分布式redission
     * @return
     */
    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.useSingleServer().
                setAddress("redis://" + redisHost + ":" + port);
                //.setPassword(password);
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }
}
