package com.geely.design.myself.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Main
 * @Description TODO
 * @Author szh
 * @Date 2023年09月20日
 */
public class Main {


    public static void main(String[] args) {
//        Flowable.just("Hello world").subscribe(System.out::println);

        AtomicInteger count = new AtomicInteger();

//        Observable.range(1, 10)
//                .doOnNext(ignored -> count.incrementAndGet())
//                .ignoreElements()
//                .andThen(Single.just(count.get()))
//                .subscribe(System.out::println);


        Observable.range(1, 10)
                .doOnNext(ignored -> count.incrementAndGet())
                .ignoreElements()
                .andThen(Single.defer(() -> Single.just(count.get())))
                .subscribe(System.out::println);

//        Observable.range(1, 10)
//                .doOnNext(ignored -> count.incrementAndGet())
//                .ignoreElements()
//                .andThen(Single.fromCallable(() -> count.get()))
//                .subscribe(System.out::println);

    }


}
