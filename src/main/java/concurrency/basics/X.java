package concurrency.basics;

public class X {

    private void write(Integer t) throws InterruptedException {
        synchronized (t){
            wait();
            notify();
            notifyAll();

        }
    }
}
