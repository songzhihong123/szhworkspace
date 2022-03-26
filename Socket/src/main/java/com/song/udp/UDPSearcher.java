package com.song.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * UDP 搜索者，用于搜索服务支持方
 */

public class UDPSearcher {
    private static final int LINTEN_PORT = 30000;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("UDPSearcher Startted...");
        Listener listen = listen();
        sendBroadcast();

        System.in.read();
        List<Device> devicesAndClose = listen.getDevicesAndClose();
        for (Device d :
                devicesAndClose) {
            System.out.println("Device:"+devicesAndClose.toString());
        }
        //完成
        System.out.println("UDPSearcher Finished...");

    }

    private static Listener listen() throws InterruptedException {
        System.out.println("UDPSearcher start listen..");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listener listener = new Listener(LINTEN_PORT,countDownLatch);
        listener.start();

        countDownLatch.await();
        return listener;
    }

    private static void sendBroadcast() throws IOException{
        System.out.println("UDPSearcher  sendBroadcast Startted...");

        //作为搜索方，让系统自动分配端口
        DatagramSocket ds = new DatagramSocket();

        String requestData = MessageCreator.builderWithPort(LINTEN_PORT);
        byte[] bytes = requestData.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        //20000端口
        packet.setAddress(InetAddress.getByName("255.255.255.255"));
        packet.setPort(20000);
        ds.send(packet);
        ds.close();

        //完成
        System.out.println("UDPSearcher sendBroadcast Finished...");
    }

    private static class Device{
        private int port;
        private String ip;
        private String sn;

        public Device(int port, String ip, String sn) {
            this.port = port;
            this.ip = ip;
            this.sn = sn;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "port=" + port +
                    ", ip='" + ip + '\'' +
                    ", sn='" + sn + '\'' +
                    '}';
        }
    }

    private static class Listener extends Thread{
        private final int listenPort;
        private final CountDownLatch countDownLatch;
        private final List<Device> devices = new ArrayList<>();
        private boolean done = false;
        private DatagramSocket ds = null;
        public Listener(int listenPort, CountDownLatch countDownLatch) {
            super();
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();

            //
            countDownLatch.countDown();
            try{
                //监听回送端口
                ds = new DatagramSocket(listenPort);
                while (!done){
                    byte[] buf = new byte[512];
                    DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);

                    ds.receive(datagramPacket);

                    String ip = datagramPacket.getAddress().getHostAddress();
                    int port = datagramPacket.getPort();
                    int length = datagramPacket.getLength();
                    String data = new String(buf,0,length);
                    System.out.println("UDPProvider receive form ip:"+ip+"\tport:"+port+"\tdata:"+data);

                    String sn = MessageCreator.parseSn(data);
                    if(sn !=null){
                        Device device = new Device(port,ip,sn);
                        devices.add(device);
                    }
                }
            }catch (Exception e){

            }finally {
                close();
            }
            System.out.println("UDPSearcher  sendBroadcast finished...");

        }

        private void close(){
            if(ds != null){
                ds.close();
                ds = null;
            }
        }
        List<Device> getDevicesAndClose(){
            done = false;
            close();
            return devices;
        }

    }


}
