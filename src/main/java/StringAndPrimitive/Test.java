package StringAndPrimitive;

/**
 * Created by niceyuanze on 17-6-24.
 */
public class Test {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1_000_000_000;i++){
            String string = new String("abcdefg");
        }
        System.out.println("non cache:  " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for(int i = 0; i < 1_000_000_000;i++){
            String string = "abcdefg";
        }
        System.out.println("cache:   " + (System.currentTimeMillis() - start));
    }
}
