package concurrency.basics;

public class A implements Runnable{
    public Integer b = 1;

    @Override
    public void run() {
        System.out.println("A is begin!");
        while (true) {
            System.out.println("a");
//             System.out.println(b);
            if (b.equals(2))
                break;
        }

        System.out.println("A is finish!");
    }

    public static void main(String[] args) {
        A a = new A();
        //Ïß³ÌA
        new Thread(a).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.b = 2;
        System.out.println("?");
    }

}
