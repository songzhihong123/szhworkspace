package com.play.exception;

public interface Assert {

    BaseException newException(Object... args);

    BaseException newException(Throwable throwable , Object... args);

    default void assertNotNull(Object obj){
        if(obj == null){
            throw newException(obj);
        }
    }

    default void assertNotNull(Object obj, Object... args){
        if(obj == null){
            throw newException(args);
        }
    }

}
