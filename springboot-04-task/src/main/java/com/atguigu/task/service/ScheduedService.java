package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduedService {

    /**
     * second(秒) ,minute(分) ,hour(时) ,day of month (日),month(月),day of week(周几)
     * 0 * * * * MON-FRI
     * 【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     * 【0 15 10 ? * 1-6】 每个与的周一到周六的10点15分执行一次
     * 【0 0 2 ? * 6L】    最月的最后一个周六2点执行一次
     * 【0 0 2 LW * ?】   每月的最后一个工作日凌晨2点执行一次
     * 【0 0 2-4 ? * 1#1】 每月的第一个周一凌晨2点到4点期间，每个整点执行一次
     */
    //@Scheduled(cron = "0 * * * * MON-FRI")
    //@Scheduled(cron = "0,1,2,3,4,5 * * * * MON-FRI")
    //@Scheduled(cron = "0-4 * * * * MON-FRI")
    //@Scheduled(cron = "0/4 * * * * MON-FRI") //每4秒执行一次
    public void hello(){
        System.out.println("hello ...");
    }

}
