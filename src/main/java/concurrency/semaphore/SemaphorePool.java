package concurrency.semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;
import java.util.function.Supplier;

public class SemaphorePool<T, R>   {
    final List<T> pool;
    final Semaphore sem;
    public SemaphorePool(int size, Supplier<T> supplier){
        pool = new Vector<>();
        for(int i = 0; i < size; i ++){
            pool.add(supplier.get());
        }
        sem = new Semaphore(size);

    }
    public R exec(Function<T,R> action) throws InterruptedException {
        try{
            T t = pool.remove(0);
            sem.acquire();
            R r = action.apply(t);
            return r;
        }finally {
            sem.release();

        }

    }

    public static void main(String[] args) throws InterruptedException {
        SemaphorePool<Thread,String> stringSemaphorePool = new SemaphorePool(10, () -> new Thread());
        Function<Thread,String> t = (Thread thread) -> {
            return "1";
        };
        stringSemaphorePool.exec(t);
    }
    

}
