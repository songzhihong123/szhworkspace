package com.play.pattern.decorator;

public class BatterCake extends ABatterCake{

    @Override
    public String desc() {
        return "batter cake";
    }

    @Override
    public int coin() {
        return 7;
    }
}
