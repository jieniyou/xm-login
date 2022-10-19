package com.xiaomin.xmlogin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@SpringBootTest
class XmLoginApplicationTests {

    @Test
    void contextLoads() {
    }


    /**
     * 使用Jedis操作redis
     */
    @Test
    void JedisTest(){

        // 1.获取连接
        Jedis jedis=new Jedis("localhost",6379);
        // 2.执行具体的操作
        jedis.set("code","3306");
        // 3.关闭连接
        jedis.close();
    }
}
