package com.song.server;

import com.song.tcp.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private final int port;
    private ClientListener mListener;
    public TCPServer(int port){
        this.port = port;
    }

    public boolean start(){
       try{
           ClientListener listener = new ClientListener(port);
           mListener = listener;
           listener.start();
       }catch(IOException e){
           e.printStackTrace();
           return false;
       }
       return true;
    }
    public void stop(){
        if(mListener != null){
            mListener.exit();
        }
    }


    private static class ClientListener extends Thread{
        private ServerSocket server;
        private boolean done = false;
        private ClientListener(int port) throws IOException {
            server = new ServerSocket(port);
            System.out.println("服务器信息："+server.getInetAddress()+" P:"+server.getLocalPort());
        }
        @Override
        public void run() {
            System.out.println("服务器准备就绪...");
            do{
                Socket client;
                try {
                    client = server.accept();
                } catch (IOException e) {
                    continue;
                }
                Server.ClientHandler handler = new Server.ClientHandler(client);
                handler.start();
            }while (!done);
            System.out.println("服务器已关闭");
        }
        void exit(){
            done = true;
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
