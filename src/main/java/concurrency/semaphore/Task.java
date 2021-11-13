package concurrency.semaphore;

import java.util.function.Function;

public class Task {
    Runnable runnable;

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
}
