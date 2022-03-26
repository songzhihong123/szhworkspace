package com.play.pattern.decorator;

public abstract class ABatterCakeDecorator extends ABatterCake{

    private ABatterCake aBatterCake;


    public ABatterCakeDecorator(ABatterCake aBatterCake){
        this.aBatterCake = aBatterCake;
    }


    abstract void doSomething();

    @Override
    public String desc() {
        return aBatterCake.desc();
    }

    @Override
    public int coin() {
        return aBatterCake.coin();
    }
}
