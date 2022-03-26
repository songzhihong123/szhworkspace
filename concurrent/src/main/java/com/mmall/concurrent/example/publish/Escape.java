package com.mmall.concurrent.example.publish;

import com.mmall.concurrent.annoation.NotRecommend;
import com.mmall.concurrent.annoation.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NotThreadSafe
@NotRecommend
public class Escape{

    public static Logger log = LoggerFactory.getLogger(Escape.class);

    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
