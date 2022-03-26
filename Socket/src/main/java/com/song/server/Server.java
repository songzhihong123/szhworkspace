package com.song.server;

import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        TCPServer tcpServer = new TCPServer(2000);
        boolean isSucceed = tcpServer.start();
        if(!isSucceed){
            System.out.println("Start TCP server faild");
            return;
        }

//        UDPProvider.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        UDPProvider.stop();
        tcpServer.stop();
    }
}
