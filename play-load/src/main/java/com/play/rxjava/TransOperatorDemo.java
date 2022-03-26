package com.play.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * author szh
 */
public class TransOperatorDemo {


    public static void main(String[] args){
        TransOperatorDemo demo = new TransOperatorDemo();
        System.out.println("===================");
        demo.test3();
        System.out.println("===================");
    }

    final Subscriber<Object> subscriber = new Subscriber<Object>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable throwable) {
        }

        @Override
        public void onNext(Object o) {
            System.out.println(o);
        }
    };

    private void test(){
        Observable.just("aaa")
                .map(new Func1<String, Object>() {
                    @Override
                    public Object call(String s) {
                        return "bbb..." + s;
                    }
                })
        .subscribe(subscriber);
    }

    private void test1(){
        Observable.just("111","333","2222")
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.just("bbb..." + s);
                    }
                }).subscribe(subscriber);

    }

    private void test2(){
        Observable.just("111","333","2222")
                .concatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.just("bbb..." + s);
                    }
                }).subscribe(subscriber);


    }

    private void test3(){
        Observable.just("1","2","3","4","5","6","7","8","9","10")
                .buffer(3)
                .subscribe(subscriber);
    }


}