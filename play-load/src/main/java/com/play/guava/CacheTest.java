package com.play.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {



    public static void main(String[] args) throws ExecutionException {
//        cacheCreateTest();
        loadingCacheTest();


    }


    public static void cacheCreateTest(){

        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(100) //设置缓存最大容量
                .expireAfterAccess(1, TimeUnit.MINUTES) //过期策略，写入一分钟后过期
                .build();
        cache.put("a","a1");
        String value = cache.getIfPresent("a");
        System.out.println(value);
    }

    public static void loadingCacheTest() throws ExecutionException {

        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .refreshAfterWrite(Duration.ofMillis(10))
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        Thread.sleep(1000);
                        System.out.println(key + " load data");
                        return key + " and value";
                    }
                });
        System.out.println(loadingCache.get("a"));
        System.out.println(loadingCache.get("b"));

    }







}
