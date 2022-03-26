package com.geely.design.pattern.structural.bridge;

/**
 * Created by Zhihong Song on 2020/12/22 13:31
 */

public class ICBCBank extends  Bank {


    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国工商银行账号");
        account.openAccount();
        return account;
    }
}
