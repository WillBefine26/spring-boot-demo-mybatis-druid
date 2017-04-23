package com.guoxin.demo;

import com.guoxin.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by guoxin on 17-3-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test() {

        User user = new User();
        user.setId(1);
        user.setPassword("123456");
        user.setUsername("admin");

        redisTemplate.opsForValue().set(String.valueOf(user.getId()), user.toString());

        String user1 = redisTemplate.opsForValue().get(String.valueOf(user.getId()));
        System.out.println(user1);
    }
}
