package com.song.myself;

public class FinallyTest {



    public int inc(){
        int x;
        try{
            x = 1;
            int a = 1 / 0;
            return x;
        }catch (Exception ex){
            x = 2;
            return x;
        }finally {
            x = 3;
        }
    }



    public static void main(String[] args) throws Exception {
        FinallyTest obj = new FinallyTest();
        System.out.println(obj.inc());


    }



}
