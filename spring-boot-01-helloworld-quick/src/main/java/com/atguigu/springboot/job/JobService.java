package com.atguigu.springboot.job;

import com.google.common.hash.BloomFilter;
import com.google.common.util.concurrent.RateLimiter;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class JobService {

    
    @XxlJob("thztest")
    public void thztest() throws Exception{
        XxlJobHelper.log("XXL-JOB, Hello World.");
        for (int i = 0; i < 5; i++) {
            System.out.println("thz at:" + i);
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
    }





}
