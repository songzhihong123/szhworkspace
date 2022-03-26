package com.play.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class Test1 {



    public static void main(String[] args){

        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> sub) {
                sub.onNext("Hello,World!");
                sub.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {
                System.out.println(2);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(1);
                System.out.println(s);
            }
        };

        myObservable.subscribe(subscriber);

        System.out.println("================================");

        Observable<String> just = Observable.just("Hello , world , action1");

        Action1<String> action1 = new Action1<String>() {

            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };

        just.subscribe(action1);

        System.out.println("===========================");

        Observable.just("Hello, world , action2")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
        System.out.println("===========================");

        Observable.just("Hello , world!!")
                .map(new Func1<String, String>() {

                    @Override
                    public String call(String s) {
                        return s + "-Dan";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
        System.out.println("===========================");



    }



}
