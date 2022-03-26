package com.atguigu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 默认支持两种技术和ES交互
 * 1、Jest(默认不生效)
 *      需要导入jest的工具包(io.searchbox.client.JestClient)
 * 2、SpringData ElaticSearch[ES版本有可能不合适]
 *      如果版本不适配：2.4.6
 *          a.升级springboot版本
 *          b.安装对应版本es
 *      1)、Client、 节点信息clusterNodes、clusterName
 *      2）、ElasticsearchTemplate 操作es
 *      3）、编写ElasticsearchRepository的子接口来操作ES
 *   两种办法：
 *      1）、编写一个ElasticsearchRepository
 */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
