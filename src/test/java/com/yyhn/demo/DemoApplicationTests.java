package com.yyhn.demo;

import com.yyhn.demo.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        ValueOperations<String, String> openration = stringRedisTemplate.opsForValue();
        System.out.println(openration.get("mykey2"));
        openration.set("huang", "车车");
        System.out.println(openration.get("huang"));
    }


    @Test
    public void test2() {
        redisTemplate.opsForValue().set("book", new Book("BBB", "Z3"));
        Book book = (Book) redisTemplate.opsForValue().get("book");
        System.out.println(book);
    }

}
