package com.geely.design.pattern.behavioral.interpreter;

/**
 * Created by Zhihong Song on 2020/12/30 11:57
 */

public class AddInterpreter implements Interpreter {

    private Interpreter firstExpression,secondExpression;

    public AddInterpreter(Interpreter firstExpression,Interpreter secondExpression){
        this.firstExpression  = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpret() {
        return this.firstExpression.interpret() + this.secondExpression.interpret();
    }

    @Override
    public String toString() {
        return "+";
    }
}
