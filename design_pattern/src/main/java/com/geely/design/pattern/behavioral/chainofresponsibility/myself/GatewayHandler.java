package com.geely.design.pattern.behavioral.chainofresponsibility.myself;

/**
 * @ClassName GatewayHandler
 * @Description TODO
 * @Author szh
 * @Date 2022年07月05日
 */
public abstract class GatewayHandler {

    private GatewayHandler nextHandler;

    public void setNextHandler(GatewayHandler nextHandler){
        this.nextHandler = nextHandler;
    }


    public abstract void service();



}
