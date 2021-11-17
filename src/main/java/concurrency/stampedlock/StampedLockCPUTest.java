package concurrency.stampedlock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampedLockCPUTest {

    /**
     *
     * ����һ����Ҫ�ر�ע�⣬�Ǿ��ǣ�����߳������� StampedLock �� readLock()
     * ���� writeLock() ��ʱ����ʱ���ø������̵߳� interrupt() �������ᵼ�� CPU �����
     * ��������Ĵ����У��߳� T1 ��ȡд��֮���Լ��������߳� T2 ���Ի�ȡ���۶�����Ҳ��������
     * �����ʱ�����߳� T2 �� interrupt() �������ж��߳� T2 �Ļ�����ᷢ���߳� T2
     * ���� CPU ������� 100%��
     * ���ԣ�ʹ�� StampedLock һ����Ҫ�����жϲ����������Ҫ֧���жϹ��ܣ�һ��ʹ�ÿ��жϵı��۶��� readLockInterruptibly() ��д�� writeLockInterruptibly()��
     * �������һ��Ҫ�����
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
