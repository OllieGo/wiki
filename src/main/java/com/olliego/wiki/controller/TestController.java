package com.olliego.wiki.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello world" + " " + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World! Post," + name;
    }

    @RequestMapping("/redis/set/{key}/{value}")
    public String set(@PathVariable Long key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value, 3600, TimeUnit.SECONDS);
        log.info("key: {}, value: {}", key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public Object get(@PathVariable Long key) {
        Object object = redisTemplate.opsForValue().get(key);
        log.info("key: {}, value: {}", key, object);
        return object;
    }
}
