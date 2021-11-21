package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(()->{
        });
        ((ExecutorService) executor).shutdown();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread = new Thread(() -> {
            countDownLatch.countDown();
        });
        thread.start();
        System.out.println(countDownLatch.getCount());
        countDownLatch.await();
    }
}
