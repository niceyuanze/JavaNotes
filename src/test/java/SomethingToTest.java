/**
 * Created by niceyuanze on 17-6-2.
 */
public class SomethingToTest {
    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2= new Integer(1);
        Integer i3 = Integer.parseInt("1");
        Integer i4 = Integer.parseInt("1");
        Integer i5 = 1;
        Integer i6= 1;
        int i7 = 1;
        Integer i8 = Integer.valueOf("1");
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i5 == i6);
        System.out.println(i6 == i7);
        System.out.println(i8 == i7);

//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Character.MIN_RADIX);
//        System.out.println(new Integer(1));

    }
}
