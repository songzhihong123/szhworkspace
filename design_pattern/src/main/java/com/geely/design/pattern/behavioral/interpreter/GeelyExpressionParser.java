package com.geely.design.pattern.behavioral.interpreter;

import java.util.Stack;

/**
 * Created by Zhihong Song on 2020/12/30 12:06
 */

public class GeelyExpressionParser {

    private Stack<Interpreter> stack = new Stack<>();

    public int parse(String str){
        String[] strItemArr = str.split(" ");
        for(String symbol : strItemArr){
            if(!OperatorUtil.isOperator(symbol)){
                NumberInterpreter numberExpression = new NumberInterpreter(symbol);
                stack.push(numberExpression);
                System.out.println(String.format("入栈：%d",numberExpression.interpret()));
            }else {
                // 是运算符号的话是可以计算的
                Interpreter firstExpression = stack.pop();
                Interpreter secondExpression = stack.pop();
                System.out.println(String.format("出栈：%d 和 %d",firstExpression.interpret(), secondExpression.interpret()));
                Interpreter operator = OperatorUtil.getExpression(firstExpression, secondExpression, symbol);
                System.out.println(String.format("运算操作符：%s",operator));
                int result = operator.interpret();
                NumberInterpreter resultExpression = new NumberInterpreter(result);
                stack.push(resultExpression);
                System.out.println(String.format("阶段性结果入栈：%d", resultExpression.interpret()));
            }
        }
        int result = stack.pop().interpret();
        return result;
    }



}
