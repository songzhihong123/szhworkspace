package com.play.test;

public class Main {

    private static final int NUM_ITERS = 100;

    public static void main(String[] args) {
        long tInit = System.nanoTime();
        int c = 0;

        for (int i = 0; i < NUM_ITERS; ++i) {
            for (int j = 0; j < NUM_ITERS; ++j) {
                for (int k = 0; k < NUM_ITERS; ++k) {
                    if (i*i + j*j == k*k) {
                        ++c;
//                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
        System.out.println(c);
        System.out.println(System.nanoTime() - tInit);
    }











}
