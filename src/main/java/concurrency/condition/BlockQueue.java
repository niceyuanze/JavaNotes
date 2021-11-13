package concurrency.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

    public class BlockQueue<T> {
    List<T> data = new ArrayList<>();

    final Lock lock = new ReentrantLock();

    final Condition notFull = lock.newCondition();

    final Condition notEmpty = lock.newCondition();

    public void enq(T x) throws InterruptedException {
        lock.lock();
        try {
            while(data.size() > 10){
                notFull.await();
            }
            data.add(x);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }
    public T deq() throws InterruptedException {
        try{
            lock.lock();
            while(data.isEmpty()){
                notEmpty.await();
            }


            notFull.signal();
            return data.remove(0);
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueue<String> blockQueue = new BlockQueue<>();
        Thread thread = new Thread(() ->{
            try {
                Thread.sleep(1000);
                blockQueue.enq("123");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        blockQueue.deq();
    }



}
