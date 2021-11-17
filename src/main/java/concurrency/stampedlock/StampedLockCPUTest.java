package concurrency.stampedlock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampedLockCPUTest {

    /**
     *
     * 还有一点需要特别注意，那就是：如果线程阻塞在 StampedLock 的 readLock()
     * 或者 writeLock() 上时，此时调用该阻塞线程的 interrupt() 方法，会导致 CPU 飙升。
     * 例如下面的代码中，线程 T1 获取写锁之后将自己阻塞，线程 T2 尝试获取悲观读锁，也会阻塞；
     * 如果此时调用线程 T2 的 interrupt() 方法来中断线程 T2 的话，你会发现线程 T2
     * 所在 CPU 会飙升到 100%。
     * 所以，使用 StampedLock 一定不要调用中断操作，如果需要支持中断功能，一定使用可中断的悲观读锁 readLockInterruptibly() 和写锁 writeLockInterruptibly()。
     * 这个规则一定要记清楚
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        StampedLock lock = new StampedLock();
        Thread  t1 = new Thread(()->{
            lock.writeLock();
            LockSupport.park();
        });
        t1.start();
        Thread.sleep(100);
        Thread t2 = new Thread(() -> {
            lock.readLock();
        });
        t2.start();
        Thread.sleep(100);
        t2.interrupt();
        t2.join();
    }
}
