package com.song.tcp;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);

        System.out.println("服务器准备就绪~");
        System.out.println("服务器信息："+serverSocket.getInetAddress()+" P:"+serverSocket.getLocalPort());

        for( ; ; ) {
            //得到客户端
            Socket accept = serverSocket.accept();
            //客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(accept);
            //启动线程
            clientHandler.start();
        }
    }

    /**
     * 客户端消息处理
     */
    public static class ClientHandler extends Thread{
        private Socket socket;
        public ClientHandler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            System.out.println("新客户端连接："+socket.getInetAddress()+" P:"+socket.getPort());
            try{
                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();

                byte[] buffer = new byte[256];
                int readCount = inputStream.read(buffer);
                ByteBuffer byteBuffer = ByteBuffer.wrap(buffer,0,readCount);
                //按顺序进行读取
                byte be = byteBuffer.get();
                char c = byteBuffer.getChar();
                int anInt = byteBuffer.getInt();
                boolean b = byteBuffer.get() == 1;
                long aLong = byteBuffer.getLong();
                float aFloat = byteBuffer.getFloat();
                double aDouble = byteBuffer.getDouble();

                int pos = byteBuffer.position();
                String str = new String(buffer,pos,readCount-pos-1);

                System.out.println("收到数量："+readCount+" 数据： "
                        + be +"\n"
                        + c +"\n"
                        + anInt +"\n"
                        + b +"\n"
                        + aLong +"\n"
                        + aFloat +"\n"
                        + aDouble +"\n"
                        + str +"\n");


                /*if(readCount > 0){
                    int value = Tools.byteArrayToInt(buffer);
                    System.out.println("收到数量: "+ readCount + " 数据："+value);
                    outputStream.write(buffer,0,readCount);
                }else{
                    System.out.println("没有收到："+readCount);
                    outputStream.write(new byte[]{0});
                }*/
                outputStream.write(buffer,0,readCount);
                inputStream.close();
                outputStream.close();
            }catch (Exception e){
                System.out.println("连接异常断开");
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("客户端已退出: "+socket.getInetAddress()+" P:"+socket.getPort());
            }
        }
    }

}
