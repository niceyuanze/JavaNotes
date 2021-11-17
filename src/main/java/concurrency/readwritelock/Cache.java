package concurrency.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Cache<K, V> {

    final Map<K,V> data = new HashMap<>();

    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    final Lock r = readWriteLock.readLock();

    final Lock w = readWriteLock.writeLock();

    V get(K key){
        r.lock();
        try{
            return data.get(key);
        }finally {
            r.unlock();
        }
    }
    V put(K key, V value){
        w.lock();
        try{
            return data.put(key, value);
        }finally {
            w.unlock();
        }
    }

    /**
     * 锁的升级，java还不行
     * @param key
     * @return
     */
    V getV2(K key){
        try{
            r.lock();
            V  value = data.get(key);
            if( value == null){
                try{
                    w.lock();

                }finally {
                    w.unlock();
                }
            }
            return value;
        }finally {
            r.unlock();
        }
    }

    /**
     * 只有写锁支持条件变量，读锁还不行
     */
    void test(){
        System.out.println(w.newCondition());
        System.out.println(r.newCondition());
    }

    void degration(){
        w.lock();
        r.lock();
    }


    public static void main(String[] args) throws InterruptedException {
        final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        final Lock r = readWriteLock.readLock();

        final Lock w = readWriteLock.writeLock();
        new Thread(){
            @Override
            public void run() {
                w.lock();
                r.lock();
            }
        }.start();
        Thread.sleep(1000);
        new Thread(){
            @Override
            public void run() {
                r.lock();
                System.out.println("1");
            }
        }.start();

    }

}
