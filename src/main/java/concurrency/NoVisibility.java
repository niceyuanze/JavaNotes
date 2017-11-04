package concurrency;

public class NoVisibility {
    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread{

        public void run(){
            while( !ready){
                System.out.println(1);
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new ReaderThread().start();
        Thread.sleep(100);
        number = 42;
        ready = true;
        System.out.println(2);

    }

}
