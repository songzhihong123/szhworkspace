package com.play.rxjava;

import lombok.SneakyThrows;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @author szh
 */
public class ToolOpratorDemo {


    public static void main(String[] args){

        ToolOpratorDemo demo = new ToolOpratorDemo();
        System.out.println("=============================");
        demo.test();
        System.out.println("============================");


    }


    public void test(){
        Observable.create(new Observable.OnSubscribe<Object>() {

            @SneakyThrows
            @Override
            public void call(Subscriber<? super Object> subscriber) {

                System.out.println("#call..... " + Thread.currentThread().getName());

                Thread.sleep(2000);
                subscriber.onNext("aaa");
                subscriber.onNext("bbb");
                subscriber.onNext("ccc");
                subscriber.onCompleted();

            }
        })//.subscribeOn(Schedulers.io()) // 主要来决定执行subscribe方法所处的线程，也就是产生事件发射事件的线程
          .doOnEach(new Observer<Object>() {
              @Override
              public void onCompleted() {

              }

              @Override
              public void onError(Throwable throwable) {

              }

              @Override
              public void onNext(Object o) {
                  System.out.println(o + "********************");
              }
          })
                .filter(new Func1<Object, Boolean>() {
                    @Override
                    public Boolean call(Object o) {
                        return o.toString().equals("aaa");
                    }
                })
         .subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("#onCompleted..... " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("#onError..... " + Thread.currentThread().getName());
            }

            @Override
            public void onNext(Object o) {
                System.out.println("#onNext..... " + o + Thread.currentThread().getName());
            }
        });


    }




}
