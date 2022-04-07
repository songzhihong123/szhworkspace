package com.play.java8.function;

import java.util.function.Consumer;

/**
 * @ClassName PresentOrElseHandler
 * @Description 值存在就进行值的处理，不存在另一段逻辑
 * @Author szh
 * @Date 2022年04月07日
 */
@FunctionalInterface
public interface PresentOrElseHandler<T extends Object> {

    void presentOrElseHandle(Consumer<? super T> action , Runnable emptyAction);
}
