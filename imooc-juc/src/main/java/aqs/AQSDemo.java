package aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class AQSDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, true);
        CountDownLatch countDownLatch = new CountDownLatch(5);

    }
}
