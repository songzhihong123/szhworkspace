package com.song.myself.daemon;

public class DaemonTest {



    public static void main(String[] args){

        Thread thread = new Thread(new Tast());
        thread.setDaemon(true);
        thread.start();


    }



}

class Tast implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("run.....");
        }finally {
            System.out.println("finally");
        }
    }
}
