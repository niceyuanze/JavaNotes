package concurrency.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 *
 * StampedLock ������֮���Ա� ReadWriteLock ��Ҫ�ã���ؼ��� StampedLock ֧���ֹ۶��ķ�ʽ
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
