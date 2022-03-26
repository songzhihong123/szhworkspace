package com.wiggin.lock;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 基于zk实现分布式锁
 */
public class ZkLock {

    private ZooKeeper zooKeeper;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private ZkLock() {
        try {
            zooKeeper = new ZooKeeper("192.168.163.130:2181,192.168.163.131:2181,192.168.163.132:2181", 5000, new ZkWatcher());
            System.out.println(zooKeeper.getState());
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ZkWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println("接收到监听事件======》"+watchedEvent);
            //如果相等就表示连接上了
            if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
                    countDownLatch.countDown();
            }
        }
    }

    /**
     * 得到分布式锁就是创建一个临时节点
     * @param id
     */
    public void lock(Integer id){
        String path = "/xdclass-product-lock-"+id;
        //创建锁的时候一定是一个临时节点,如果创建成功则表示得到锁，如果失败则要不断的尝试
        try {
            zooKeeper.create(path,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (Exception e) {
            while (true){
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    zooKeeper.create(path,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                } catch (Exception e1) {
                    continue;
                }
                break;
            }
        }
    }

    /**
     * 释放锁，就是将节点删除
     * @param id
     */
    public void unLock(Integer id){
        String path = "/xdclass-product-lock-"+id;
        try {
            zooKeeper.delete(path,-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static ZkLock getInstance(){
        return Singleton.getInstance();
    }

    private static class Singleton{
        private static ZkLock instance;
        static{
            instance = new ZkLock();
        }

        private static ZkLock getInstance(){
            return instance;
        }
    }

}
