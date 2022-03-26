package com.geely.design.pattern.structural.adapter;

/**
 * Created by Zhihong Song on 2020/11/19 18:37
 */

public class PowerAdapter implements DC5 {

    private AC220 ac220 = new AC220();

    @Override
    public int outputDC5() {
        int adaptInput = ac220.outputAC220V();

        //变压器....
        int adaprOutput = adaptInput / 44;

        System.out.println("使用 PowerAdapter 输入AC" + adaptInput + "V ,输出直流电DC "+ adaprOutput + "V");

        return adaprOutput;
    }
}
