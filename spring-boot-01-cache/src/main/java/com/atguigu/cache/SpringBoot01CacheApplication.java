package com.atguigu.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环境
 *      1.导入数据库文件，创建department和employee表
 *      2.创建javabean封装数据
 *      3.整合MyBatis操作数据库
 *          1.配置数据源信息
 *          2.使用注解版的mybatis:
 *              1)、使用@MapperScan指定需要扫描的Mapper接口所在的包
 *  二、快速体验缓存
 *      步骤：
 *          1.开启基于注解的缓存
 *          2.标注缓存注解即可
 *              @Cacheable
 *              @CacheEvict
 *              @CachePut
 *  默认使用的ConcurrentMapCancheManager ==> ConcurrentMapCanche;  将数据保存在CurrentMap中
 *  开发中的经常使用缓存中间件；redis、memcahed、ehcache;
 *
 * 三、整合Redis作为缓存
 *   1、安装redis，使用docker
 *   2、引入redis的starter
 *   3、配置redis
 *   4、测试缓存
 *          原理：CancheManager === Cache  缓存组件实际给缓存中存取数据
 *          1）、引入redis的starter ，容器中保存的是ReidsCacheManager；
 *          2）、ReidsCacheManager 帮我们创建RedisCache来作为缓存组件，RedisCache通过操作redis缓存数据的
 *          3）、默认保存数据 k - v 都是Object；利用序列化来保存的；如何保存Json
 *                  1、引入了reids的starter，cacheManager 变为 RedisCacheManager；
 *                  2、默认创建的RedisCacheManager 操作Redis的时候 使用的是 RedisTemplate<Object, Object>
 *                  3、RedisTemplate<Object, Object> 是RedisAutoConfiguration 提供的的，默认使用的是Jdk【JdkSerializationRedisSerializer】序列化机制
 *          4)、自定义CacheManager；
 *
 */
@MapperScan("com.atguigu.cache.mapper")
@SpringBootApplication
//@EnableCaching
public class SpringBoot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01CacheApplication.class, args);
    }

}
