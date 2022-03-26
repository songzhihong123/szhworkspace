package com.geely.design.pattern.structural.bridge;

/**
 * Created by Zhihong Song on 2020/12/22 13:36
 *
 * 桥接模式,把具体和抽象组合起来
 * 妙不可言！！！！！！
 * 把子类的引用传到父类，然后再用福来去调用子类的方法
 */

public class Test {

    public static void main(String[] args) {
        Bank icbck = new ICBCBank(new DepositAccount());
        Account icaccount = icbck.openAccount();
        icaccount.showAccountType();

        Bank icbck2 = new ICBCBank(new SavingAccount());
        Account icaccount2 = icbck2.openAccount();
        icaccount2.showAccountType();

        Bank abcBank = new ABCBank(new SavingAccount());
        Account abcCcount = abcBank.openAccount();
        abcCcount.showAccountType();

        Bank abcBank2 = new ABCBank(new DepositAccount());
        Account abcCcount2 = abcBank2.openAccount();
        abcCcount2.showAccountType();
    }

}
