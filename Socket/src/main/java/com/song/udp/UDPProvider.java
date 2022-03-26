package com.song.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.UUID;

/**
 * UDP 提供者，用于提供服务
 */
public class UDPProvider {
    public static void main(String[] args) throws IOException {
        //生成唯一标识
        String sn = UUID.randomUUID().toString();
        Prvoder prvoder = new Prvoder(sn);
        prvoder.start();

        //读取任意键盘后可以退出
        System.in.read();
        prvoder.exit();
    }

    //我们想要随时的停止和持续的监听，那么我们需要一个线程
    private static class Prvoder extends Thread{
        private final String sn;
        private boolean done = false;
        private DatagramSocket ds = null;
        public Prvoder(String sn) {
            super();
            this.sn = sn;
        }

        @Override
        public void run() {
            System.out.println("UDPProvider Startted...");
            try{
                //监听20000
                ds = new DatagramSocket(20000);
                while(!done){
                //构建一个接收数据的实体
                byte[] buf = new byte[512];
                DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);
                //接收
                ds.receive(datagramPacket);

                //打印接收到的信息与发送者的信息
                //发送者的IP地址
                String ip = datagramPacket.getAddress().getHostAddress();
                int port = datagramPacket.getPort();
                int length = datagramPacket.getLength();
                String data = new String(buf,0,length);
                System.out.println("UDPProvider receive form ip:"+ip+"\tport:"+port+"\tdata:"+data);

                //解析端口号
                int responsePort = MessageCreator.parsePort(data);
                if(responsePort != -1){
                //构建一份回送数据
                String responseData = MessageCreator.buildWithSn(sn);
                byte[] bytes = responseData.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes,
                        bytes.length,
                        datagramPacket.getAddress(),
                        responsePort);

                ds.send(packet);
                }
                }
            }catch (Exception ignored){

            }finally {
                close();
            }
            System.out.println("UDPProvider Finished...");
        }

        private void close(){
            if(ds != null){
                ds.close();
                ds=null;
            }
        }
        public void exit(){
            done = true;
            close();
        }

    }

}
