package StringAndPrimitive;

/**
 * Created by niceyuanze on 17-6-2.
 */
public class PrimitiveConstantPool {
    public static void main(String[] args) {
        int i = 40;
        int i0 = 40;
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        Double d1=1.0;
        Double d2=1.0;

        //1、这个没解释的就是true
        System.out.println("i=i0\t" + (i == i0));  //true
        //2、int值只要在-128和127之间的自动装箱对象都从缓存中获取的，所以为true
        System.out.println("i1=i2\t" + (i1 == i2));  //true
        //3、涉及到数字的计算，就必须先拆箱成int再做加法运算，所以不管他们的值是否在-128和127之间，只要数字一样就为true
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));//true
        //比较的是对象内存地址，所以为false
        System.out.println("i4=i5\t" + (i4 == i5));  //false
        //5、同第3条解释，拆箱做加法运算，对比的是数字，所以为true
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));//true
        //double的装箱操作没有使用缓存，每次都是new Double，所以false
        System.out.println("d1=d2\t" + (d1==d2));//false
    }
}
