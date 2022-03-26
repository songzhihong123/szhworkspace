package com.song.day1.tcp;

import com.song.day1.bean.ServerInfo;

public class Client {
    public static void main(String[] args) {
        ServerInfo info = ClientSearcher.searchServer(10000);
        System.out.println("Server: "+info);
    }
}
