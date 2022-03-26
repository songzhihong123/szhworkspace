package com.geely.design.pattern.structural.bridge;

/**
 * Created by Zhihong Song on 2020/12/22 13:30
 */

public class ABCBank extends Bank {


    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
