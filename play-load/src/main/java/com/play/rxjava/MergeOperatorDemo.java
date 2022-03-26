package com.play.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @author szh
 */
public class MergeOperatorDemo {



    public static void main(String[] args){
        MergeOperatorDemo demo = new MergeOperatorDemo();
        System.out.println("===================");
        demo.test();
        System.out.println("===================");
    }

    final Subscriber<Object> subscriber = new Subscriber<Object>() {
        @Override
        public void onCompleted() {
            System.out.println("#onCompleted......");
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("#onError......");
        }

        @Override
        public void onNext(Object o) {
            System.out.println("#onNext......");
            System.out.println(o);
        }
    };

    private void test(){
        Observable.concat(Observable.just("111") ,
                Observable.just("222"))
                .subscribe(subscriber);
    }


}
