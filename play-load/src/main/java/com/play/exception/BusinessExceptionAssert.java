package com.play.exception;

public interface BusinessExceptionAssert extends IResponseEnum , Assert{



    @Override
    default BaseException newException(Object... args) {
        String msg = "";

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = "";

        return new BusinessException(this, args, msg, t);
    }


}
