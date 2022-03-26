package com.geely.design.pattern.structural.bridge;

/**
 * Created by Zhihong Song on 2020/12/22 13:23
 */

public class SavingAccount implements Account {

    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }

}
