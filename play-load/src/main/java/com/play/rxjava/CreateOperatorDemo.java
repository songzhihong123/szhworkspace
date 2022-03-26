package com.play.rxjava;


import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Callable;

/**
 * @author  szh
 */
public class CreateOperatorDemo {



    public static void main(String[] args){
        CreateOperatorDemo demo = new CreateOperatorDemo();
        System.out.println("===========================");
        demo.test3();
        System.out.println("===========================");


    }

    final Subscriber<Object> subscriber = new Subscriber<Object>() {
        @Override
        public void onCompleted() {
            System.out.println("onCompleted.......");
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Object s) {
            System.out.println("onNext.......");
            System.out.println(s);
        }
    };

    private  void test1(){
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                subscriber.onNext("1");
                subscriber.onNext("2");
                subscriber.onNext("3");
                subscriber.onCompleted();
            }
        }).subscribe(subscriber);

    }

    private  void test2(){
        Observable.just("aa","bb","cc")
                .subscribe(subscriber);
    }

    private  void test3(){
        String[] str = {"aa","bb","cc","aa","bb","cc","aa","bb","cc"};
//        Observable.from(str)
//                .subscribe(subscriber);
        Observable.fromCallable(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "123456";
            }
        }).subscribe(subscriber);
    }






}
