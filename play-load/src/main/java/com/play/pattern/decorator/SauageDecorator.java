package com.play.pattern.decorator;

public class SauageDecorator extends ABatterCakeDecorator{

    public SauageDecorator(ABatterCake aBatterCake){
        super(aBatterCake);
    }


    @Override
    void doSomething() {

    }

    @Override
    public String desc() {
        return super.desc() + " ##add a sauage## ";
    }

    @Override
    public int coin() {
        return super.coin() + 2;
    }
}
