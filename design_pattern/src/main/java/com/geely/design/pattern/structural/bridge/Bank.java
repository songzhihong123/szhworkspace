package com.geely.design.pattern.structural.bridge;

/**
 * Created by Zhihong Song on 2020/12/22 13:26
 */

public abstract class Bank {

    protected Account account;

    public Bank(Account account){
        this.account = account;
    }

    abstract Account openAccount();

}
