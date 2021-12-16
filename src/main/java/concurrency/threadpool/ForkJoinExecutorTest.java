package concurrency.threadpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExecutorTest {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(4);
        Fibonacci fib = new Fibonacci(30);
        Integer result = fjp.invoke(fib);
        System.out.println(result);
    }

    //�ݹ�����
    static class Fibonacci extends RecursiveTask<Integer> {
        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        protected Integer compute() {
            if (n <= 1){
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            //����������
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            f2.fork();
            //�ȴ��������������ϲ����
            return f2.join() + f1.join();

        }
    }
}
