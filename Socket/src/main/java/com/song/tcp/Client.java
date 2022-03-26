package com.song.tcp;

import java.io.*;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket();
        //设置一个超时的时间
        socket.setSoTimeout(3000);
        //连接本地，设置超时时间3000ms
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),2000),3000);

        System.out.println("已发起服务器连接，并进入后续流程");
        System.out.println("客户端信息："+socket.getLocalAddress()+" P:"+socket.getLocalPort());
        System.out.println("服务器信息："+socket.getInetAddress()+" P:"+socket.getPort());

        try{
            todo(socket);
        }catch (Exception e){
            System.out.println("异常关闭");
        }

        //资源释放
        socket.close();
        System.out.println("客户端已退出");

    }

    private static void todo(Socket client) throws IOException{
        //获取一个输出流
        OutputStream outputStream = client.getOutputStream();

        InputStream inputStream = client.getInputStream();
        byte[] buffer = new byte[256];

        ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
        //byte
        byteBuffer.put((byte)126);
        //char
        char c = 'a';
        byteBuffer.putChar(c);
        //int
        int i = 2323123;
        byteBuffer.putInt(i);
        //bool
        boolean b = true;
        byteBuffer.put(b?(byte) 1:(byte) 0);
        //long
        long l = 1234579;
        byteBuffer.putLong(l);
        //float
        float f = 12.345f;
        byteBuffer.putFloat(f);
        //double
        double d = 12.456464654831;
        byteBuffer.putDouble(d);
        //String
        String str = "hello你好！";
        byteBuffer.put(str.getBytes());


//        byte[] ins = Tools.intToByteArray(2323123);


       //发送到服务器
       outputStream.write(buffer,0,byteBuffer.position()+1);

       int read = inputStream.read(buffer);
      /* if(read>0){
           System.out.println("收到数量: "+ read + " 数据："+ Array.getByte(buffer,0));
       }else{
           System.out.println("没有收到："+read);
       }*/
        System.out.println("收到数量："+read);

       //资源释放
        inputStream .close();
        outputStream.close();
    }
}
