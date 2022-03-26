package com.play.rxjava;

import com.sun.media.jfxmediaimpl.MediaDisposer;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Test2 {


    public static void main(String[] args){
/*
        Observable.interval(3000 , TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("error: " + throwable.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("ontext: " + aLong);
                    }
                });*/

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println( "timer：当前时间 ==" + dateFormat.format(System.currentTimeMillis()));
        //延时10秒后，发送一个long值为0的事件
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println( "timer：onNext ==" + aLong + "   时间 ==" + dateFormat.format(System.currentTimeMillis()));
                    }


                    @Override
                    public void onError(Throwable e) {
                        System.out.println( "timer：onError == " + e.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("timer：onComplete == ");
                    }
                });
        
        

    }


}
