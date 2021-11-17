package concurrency.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 *
 * StampedLock 的性能之所以比 ReadWriteLock 还要好，其关键是 StampedLock 支持乐观读的方式
 */
public class StampedLockTest {
    public static void main(String[] args) {
        StampedLock sl = new StampedLock();
//        System.out.println(sl.tryOptimisticRead());
//        System.out.println(sl.tryOptimisticRead());

        System.out.println(sl.readLock());
        System.out.println(sl.readLock());

//        System.out.println(sl.writeLock());
    }
}
