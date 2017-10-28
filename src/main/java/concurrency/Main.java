package concurrency;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        UnsafeSequence unsafeSequence = new UnsafeSequence();

        for(int i = 0; i < 2; i++){
            new Thread( () -> {
                for(int j= 0; j < 10000; j++){
                    unsafeSequence.getNext();
                }
            }).start();
        }

//        new Thread( () -> {
//            IntStream.rangeClosed(0, 10).forEach(i -> {
//
//            });
//        }).start();
    }
}
