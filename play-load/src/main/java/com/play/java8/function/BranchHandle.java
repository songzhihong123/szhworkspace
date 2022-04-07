package com.play.java8.function;

/**
 * @ClassName BranchHandle
 * @Description 成功和失败分别要去处理的handler
 * @Author szh
 * @Date 2022年04月07日
 */
@FunctionalInterface
public interface BranchHandle {



    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);


}
