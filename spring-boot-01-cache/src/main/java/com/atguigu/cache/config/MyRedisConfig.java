//package com.atguigu.cache.config;
//
//import com.atguigu.cache.bean.Department;
//import com.atguigu.cache.bean.Employee;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
//import java.net.UnknownHostException;
//
//@Configuration
//public class MyRedisConfig {
//
//
//    @Bean
//    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, Employee> template = new RedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer res = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
//        template.setDefaultSerializer(res);
//        return template;
//    }
//
//    @Bean
//    public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, Department> template = new RedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer res = new Jackson2JsonRedisSerializer<Department>(Department.class);
//        template.setDefaultSerializer(res);
//        return template;
//    }
//
//    //CacheManagerCustomizers 可以来定制缓存的一些规则
//    //@Primary 默认使用的CacheManager
//    @Primary
//    @Bean
//    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
//        //key 多了一个前缀
//
//        //使用前缀，默认会将CacheName作为key的前缀
//        cacheManager.setUsePrefix(true);
//        return cacheManager;
//    }
//
//    @Bean
//    public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> deptRedisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(deptRedisTemplate);
//        //key 多了一个前缀
//        //使用前缀，默认会将CacheName作为key的前缀
//        cacheManager.setUsePrefix(true);
//        return cacheManager;
//    }
//
//}
