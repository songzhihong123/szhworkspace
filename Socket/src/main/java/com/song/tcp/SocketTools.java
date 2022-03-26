package com.song.tcp;

import java.io.IOException;
import java.net.*;

public class SocketTools {
    private static final int PORT = 20000;
    private static final int LOCAL_PORT = 20001;

    public static Socket createSocket() throws IOException {
        /*
        //无代理模式，等效于空的构造函数
        Socket socket = new Socket(Proxy.NO_PROXY);

        //新建一份具有HTTP代理的套接字，传输数据将通过www.baidu.com:8800端口转发
        Proxy proxy  = new Proxy(Proxy.Type.HTTP,
                new InetSocketAddress(Inet4Address.getByName("www.baidu.com"),8800));
        socket = new Socket(proxy);

        //新建一个套接字，并且直接链接到本地20000的服务器上
        socket = new Socket("localhost",PORT);

        //新建一个套接字，并且直接链接到本地20000的服务器上
        socket = new Socket(Inet4Address.getLocalHost(),PORT);

        //新建一个套接字，并且直接连接到本地20000的服务器上，并且绑定在本地的20001端口上
        socket = new Socket("localhost",PORT,Inet4Address.getLocalHost(),LOCAL_PORT);
        socket = new Socket(Inet4Address.getLocalHost(),PORT,Inet4Address.getLocalHost(),LOCAL_PORT);
        */
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress(Inet4Address.getLocalHost(),LOCAL_PORT));


        return socket;

    }

    public  static void initSocket(Socket socket) throws SocketException{
        //设置超时时间为3秒
        socket.setSoTimeout(3000);

        //是否复用完全关闭的Socket地址，对于指定的bind操作后的套接字有效
        /*
        * 默认Socket完全关闭的2分钟是不可以被复用的，
        * 设置这个属性为true之后是完全关闭可以立马被服用的
        * */
        socket.setReuseAddress(true);

        //是否开启Nagle算法
        /*
        * Nagle算法指的是接受到信息要不要立刻回送接收到消息的标志
        * 当我们只发送一个字节的数据的时候，如果立刻回送消息，那么回送的确认接受的消息比我们
        * 要发的消息还要大的时候，那么就不值得立刻回送。
        *
        * 发送消息端因为没有接受到确认接受的标志，所以，一直迟迟不发送消息，当接受到确认消息的标志之后
        * 就会将之前所有的消息发送出去
        *
        * 这个方发是用来优化空间的，默认是开启的
        * */
        socket.setTcpNoDelay(true);

        //是否需要在长时间无数据响应时发送确认数据（类似心跳包），时间大约为2小时
        /**
         * 在长时间两者没有进行任何数据的传输，2个小时之后就会发送一个确认消息，
         * 如果没有收到回送消息的时候，就默认这个链接已经断了。
         *
         * true代表开启，false代表不开启
         */
        socket.setKeepAlive(true);

        /**
         * 对于close关闭操作行为进行怎么的处理；默认为false 0；
         * false、0：默认情况，关闭的时候理解返回，底层系统接管输出流，将缓冲区内的数据发送完成
         * true、0:关闭时立即返回，缓冲区数据抛弃，直接发送RST结束命令到对方，并无需经过 2MSL 等待
         * true、200：关闭的时候最长阻塞200毫秒，随后按第二种情况处理
         *
         * MSL指的是数据包最长到达的理论时间
         */
        socket.setSoLinger(true,20);

        //是否让紧急数据内敛，默认false，紧急数据通过 socket.sendUrgentData(1);发送
        /**
         * 建议不要开启，开启之后可以会导致紧急数据与行为数据混合，导致数据脏乱
         */
        //socket.setOOBInline(true);

        //设置接受发送缓冲器的大小，默认是32k
        socket.setReceiveBufferSize(64*1024*1024);
        socket.setSendBufferSize(64*1024*1024);

        //设置性能参数：短链接，延迟，带宽的相对重要性，只是设置一个权重
        socket.setPerformancePreferences(1,1,1);
    }

}
