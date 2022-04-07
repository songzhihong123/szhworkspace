package com.play.java8.function;

/**
 * @ClassName ThrowExceptionFunction
 * @Description 处理异常的function
 * @Author szh
 * @Date 2022年04月07日
 */
@FunctionalInterface
public interface ThrowExceptionFunction {


    void throwMessage(RuntimeException exception);

}
