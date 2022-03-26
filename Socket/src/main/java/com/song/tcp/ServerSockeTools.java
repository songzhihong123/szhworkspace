package com.song.tcp;

import javafx.scene.effect.Light;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public class ServerSockeTools {

    private static final int PORT = 20000;

    public static ServerSocket createServerSocket() throws IOException {

        //创建一个基础的ServerSocket
        ServerSocket serverSocket = new ServerSocket();
        //绑定到本地的端口上 参数 50 代表的允许等待的连接数
        /**
         * 当服务器端进去accept的时候，允许有50个客户端等待连接，如果有第51个连接的话就会触发一个异常
         */
        serverSocket.bind(new InetSocketAddress(Inet4Address.getLocalHost(),PORT),50);

        /*
        //绑定到本地端口20000上，并且设置当前课允许等待链接的队列为50个
        serverSocket = new ServerSocket(PORT);

        //等效于上面的方案，队列设置为50个
        serverSocket = new ServerSocket(PORT,50);
        */
        //与上面相同
        serverSocket = new ServerSocket(PORT,50,Inet4Address.getLocalHost());
        return serverSocket;

    }

    private static void initServerSocket(ServerSocket serverSocket) throws SocketException {

        //是否复用完全关闭的serverSocket地址，对于指定的bind操作后的套接字有效
        serverSocket.setReuseAddress(true);
        //设置接收的缓冲区的大小
        serverSocket.setReceiveBufferSize(64*1024*1024);

        //设置serverSocket accept 的超时时间 不建议使用
        serverSocket.setSoTimeout(2000);

        //设置性能参数：短链接，延迟，带宽的相对重要性
        serverSocket.setPerformancePreferences(1,1,1);
    }

}
