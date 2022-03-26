package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    //操作字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //key - value  都是对象的
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;


    /**
     * Redis 的常见五大数据类型
     * string 字符串 、 List 列表、 Set 集合、Hash 散列 ZSet 有序集合
     *
     *  stringRedisTemplate.opsForValue();
     *  stringRedisTemplate.opsForList();
     *  stringRedisTemplate.opsForHash();
     *  stringRedisTemplate.opsForSet();
     *  stringRedisTemplate.opsForZSet();
     */
    @Test
    public void test01(){
        // 给redis保存一个数据
        //stringRedisTemplate.opsForValue().append("msg","hello");
        //System.out.println(stringRedisTemplate.opsForValue().get("msg"));
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
    }
    //测试保存对象
    @Test
    public void test02(){
        Employee empById = employeeMapper.getEmpById(1);
        //默认如果保存结果，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",empById);
        //1.将数据以json的方式保存
        //（1）、自己转为json格式
        //（2）、redisTemplate默认的序列化规则; 改变序列化器的默人规则
        empRedisTemplate.opsForValue().set("emp-02",empById);
    }


    @Test
    public void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

}
