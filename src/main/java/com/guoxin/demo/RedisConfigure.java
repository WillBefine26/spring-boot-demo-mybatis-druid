package com.guoxin.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * TODO 下面使用了手动读取application.properties 中的配置
 * 不知道为什么AutoConfiguration不好使暂时先不纠结以后在说
 *
 * Created by guoxin on 17-4-22.
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfigure {

    @Value("${spring.redis.password}")
    private String springRedisPassword;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        System.out.println(springRedisPassword);
        jedisConnectionFactory.setPassword(springRedisPassword);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplateObject() {
        final RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericToStringSerializer<>(Object.class));
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }
}