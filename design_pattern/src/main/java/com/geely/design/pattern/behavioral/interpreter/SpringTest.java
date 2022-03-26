package com.geely.design.pattern.behavioral.interpreter;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by Zhihong Song on 2020/12/30 15:09
 */

public class SpringTest {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("100 * 2 + 400 * 1 + 66");
        Integer value = (Integer)expression.getValue();
        System.out.println(value);
    }

}
