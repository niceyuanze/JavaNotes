package concurrency.threadpool;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(1),(r) ->{
            Thread t = new Thread(r);
            t.setName("´óË§×Ó");
            System.out.println(1);
            return t;

        },new ThreadPoolExecutor.DiscardOldestPolicy());

        threadPoolExecutor.submit(()->{
            System.out.println("456-1");

            throw new NullPointerException();
        });
        System.out.println("123");
        Long test = 123L;
        Future future = threadPoolExecutor.submit(()->{
            System.out.println("456-2");
        },test);
        System.out.println(future.get());
        FutureTask futureTask = new FutureTask<>(()-> 1+2);
        threadPoolExecutor.submit(futureTask);

//        threadPoolExecutor.execute(()->{
//            throw new NullPointerException();
//
//        });
//        threadPoolExecutor.execute(()->{
//            throw new NullPointerException();
//
//        });
//        threadPoolExecutor.submit(()->{
//            System.out.println("456-3");
//
//        });
//        new Thread(()->{
//            System.out.println("1");
//        });
//        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

}
