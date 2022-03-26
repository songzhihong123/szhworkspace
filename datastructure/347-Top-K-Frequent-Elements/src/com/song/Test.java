package com.song;

public class Test {

    private static class Freq implements Comparable<Freq>{
        int freq;

        public Freq(){
        }

        public Freq(int freq){
            this.freq = freq;
        }
        @Override
        public int compareTo(Freq another) {
            if(this.freq < another.freq){
                return -1;
            }else if(this.freq > another.freq){
                return 1;
            }else
                return 0;
        }
    }

    public static void main(String[] args) {
        Freq f1 = new Freq(5);
        Freq f2 = new Freq(6);
        System.out.println(f1.compareTo(f2));
    }

}
