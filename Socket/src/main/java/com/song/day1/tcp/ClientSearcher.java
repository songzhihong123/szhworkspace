package com.song.day1.tcp;

import com.song.day1.bean.ServerInfo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ClientSearcher {

    private static final int LISTEN_PORT = 30202;

    public static ServerInfo searchServer(int timeout) throws InterruptedException {
        System.out.println("UDPSearcher Started...");

        //成功收到返回送的栅栏
        CountDownLatch receiveLatch = new CountDownLatch(1);
        receiveLatch.await(10000, TimeUnit.MILLISECONDS);

        return null;
    }



}
