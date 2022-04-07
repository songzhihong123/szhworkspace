package com.play.java8.function;

/**
 * @ClassName VUtils
 * @Description TODO
 * @Author szh
 * @Date 2022年04月07日
 */
public class VUtils {

    /*
    * 根据参数判断是否需要抛出异常
    */
    public static ThrowExceptionFunction isTrue(boolean b){

        return message -> {
            if(b){
                throw new RuntimeException(message);
            }
        };

    }

    /*
     * 根据参数判断分别选择不同的处理器
     */
    public static BranchHandle ifTrueOrFalse(boolean b){

        return (trueHandle, falseHandle) -> {
            if (b) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }

    /*
     * 对参数进行校验，失败和成功时进行不同发业务逻辑
     */
    public static PresentOrElseHandler<?> isBlankOrNoBlank(String str){
        return ((action, emptyAction) -> {
            if(str == null || str.length() == 0){
                emptyAction.run();
            }else{
                action.accept(str);
            }
        });
    }


}
