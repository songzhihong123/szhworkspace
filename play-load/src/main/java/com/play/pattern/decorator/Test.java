package com.play.pattern.decorator;

public class Test {


    public static void main(String[] args){

        ABatterCake cake = new BatterCake();

        cake = new EggDecotator(cake);

        System.out.println(cake.desc() + "  price is: " + cake.coin());

        cake = new SauageDecorator(cake);

        System.out.println(cake.desc() + "  price is: " + cake.coin());

    }



}
