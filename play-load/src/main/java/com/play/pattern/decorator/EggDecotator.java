package com.play.pattern.decorator;

public class EggDecotator extends ABatterCakeDecorator{


    public EggDecotator(ABatterCake aBatterCake){
        super(aBatterCake);
    }


    @Override
    void doSomething() {

    }

    @Override
    public String desc() {
        return super.desc() + " ##add a egg## ";
    }

    @Override
    public int coin() {
        return super.coin() + 1;
    }
}
