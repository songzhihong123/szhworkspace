package com.geely.design.pattern.behavioral.interpreter;

/**
 * Created by Zhihong Song on 2020/12/30 12:09
 */

public class OperatorUtil {

    public static boolean isOperator(String symbol){
        return ("+".equals(symbol) || "*".equals(symbol));
    }

    public static Interpreter getExpression(Interpreter firstExpression,Interpreter secondExpression,String symbol){
        if(symbol.equals("+")){
            return new AddInterpreter(firstExpression,secondExpression);
        }else if(symbol.equals("*")){
            return new MultiInterpreter(firstExpression,secondExpression);
        }
        return null;
    }

}
