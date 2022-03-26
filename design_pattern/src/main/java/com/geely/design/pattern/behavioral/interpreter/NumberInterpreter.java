package com.geely.design.pattern.behavioral.interpreter;

/**
 * Created by Zhihong Song on 2020/12/30 12:02
 */

public class NumberInterpreter implements Interpreter {

    private int num;

    public NumberInterpreter(int num){
        this.num = num;
    }

    public NumberInterpreter(String num){
        this.num = Integer.parseInt(num);
    }

    @Override
    public int interpret() {
        return this.num;
    }
}
