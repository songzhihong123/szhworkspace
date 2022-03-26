package com.song;

import java.util.Comparator;

public class Test1 {

    private static class Freq{
        int freq;

        public Freq(){
        }

        public Freq(int freq){
            this.freq = freq;
        }
    }

    private static class FreqCom implements Comparator<Freq>{

        @Override
        public int compare(Freq a, Freq b) {
            if(a.freq < b.freq){
                return -1;
            }else if(a.freq > b.freq){
                return 1;
            }else
                return 0;
        }
    }


    public static void main(String[] args) {
       FreqCom com = new FreqCom();
        Freq f1 = new Freq(5);
        Freq f2 = new Freq(6);
        System.out.println(com.compare(f1, f2));
    }

}
