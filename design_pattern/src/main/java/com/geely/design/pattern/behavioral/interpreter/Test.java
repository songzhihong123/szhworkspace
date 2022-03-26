package com.geely.design.pattern.behavioral.interpreter;

/**
 * Created by Zhihong Song on 2020/12/30 11:54
 *
 * 解释器模式
 */

public class Test {

    public static void main(String[] args) {
        String geelyInputStr  = "6 100 11 + *";
        GeelyExpressionParser geelyExpressionParser = new GeelyExpressionParser();
        int parse = geelyExpressionParser.parse(geelyInputStr);
        System.out.println("解释器结算结果：" + parse);
    }

}
