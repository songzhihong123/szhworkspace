package com.mmall.concurrent.example.publish;

import com.mmall.concurrent.annoation.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@NotThreadSafe
public class UnsafePublish {
    public static Logger log = LoggerFactory.getLogger(UnsafePublish.class);
    private String[] stats = {"a","b","c"};
    public String[] getStats(){
        return stats;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStats()));


        unsafePublish.getStats()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStats()));

    }
}
