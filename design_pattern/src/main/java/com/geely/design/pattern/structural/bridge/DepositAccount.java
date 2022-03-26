package com.geely.design.pattern.structural.bridge;

/**
 * Created by Zhihong Song on 2020/12/22 13:22
 */

public class DepositAccount implements Account {

    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
