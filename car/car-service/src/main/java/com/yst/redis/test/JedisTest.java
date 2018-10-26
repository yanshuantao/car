package com.yst.redis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yst.service.impl.RedisCache;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring/*.xml","classpath:mybatis/*.xml"})  
@Component
public class JedisTest {

	@Autowired
	private RedisCache redisCache;
    @Test
    public void test7() throws Exception{
        List<String> list = new ArrayList<String>();
        list.add("测试list");
        list.add("测试list2");
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("test*","测试数据");
        map.put("测试数据","啥的");
        map.put("listTest",list);
        redisCache.putCache("testMap",map);

        Map<String,Object> mapResult = redisCache.getCache("testMap");
        System.out.print(mapResult.toString());
    }
    public static void main(String[] args) {
    	Jedis jedis=new Jedis("192.168.168.128", 6379);
    	jedis.sadd("test", "111");

	}
}