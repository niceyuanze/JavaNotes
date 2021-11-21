package concurrency.threadpool;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(1),(r) ->{
            Thread t = new Thread(r);
            t.setName("ÔÀÔ¶Ôó");
            System.out.println(1);
            return t;

        },new ThreadPoolExecutor.DiscardOldestPolicy());

        threadPoolExecutor.submit(()->{
            System.out.println("456-1");

            throw new NullPointerException();
        });
        System.out.println("123");
        threadPoolExecutor.submit(()->{
            System.out.println("456-2");

        });
        threadPoolExecutor.execute(()->{
            throw new NullPointerException();

        });
        threadPoolExecutor.execute(()->{
            throw new NullPointerException();

        });
        threadPoolExecutor.submit(()->{
            System.out.println("456-3");

        });
//        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

}
