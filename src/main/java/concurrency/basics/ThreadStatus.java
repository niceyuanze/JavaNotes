package concurrency.basics;

public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
//                    Thread.sleep(1000);
                    System.out.println(1);
                    if(this.isInterrupted()){
                        System.out.println("???");
                    }

                } catch (Exception e) {
                    System.out.println(this.isInterrupted());
                    System.out.println(e.getStackTrace()[0]);
                    e.printStackTrace();
                }
            }
        };
        System.out.println(thread.getState()); // NEW
        thread.start();
//        Thread.sleep(100);
        thread.interrupt();
        System.out.println(thread.getState()); // TIMED_WAITING
        System.out.println(thread.isInterrupted());
        System.out.println(thread.getState()); // TERMINATED

    }
}
