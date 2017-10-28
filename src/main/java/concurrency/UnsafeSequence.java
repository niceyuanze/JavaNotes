package concurrency;

public class UnsafeSequence {
    private int value;

    public void getNext(){
//        for(int i = 0; i < 10;i++){
//                    value++;
//            System.out.println(value);
//        }
        value++;
        System.out.println(value);
    }
}
