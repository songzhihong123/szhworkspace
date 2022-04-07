package com.play.exception;

public abstract class BaseException extends RuntimeException{

    private int code;

    private String message;

    public BaseException(){

    }

    public BaseException(IResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public BaseException(IResponseEnum responseEnum , Object args , String message){

    }

    public BaseException(IResponseEnum responseEnum , Object args , String message, Throwable throwable){

    }



}
