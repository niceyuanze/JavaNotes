package StringAndPrimitive;

/**
 * Created by niceyuanze on 17-6-2.
 */
public class StringConstantPool {

    /**
     * 常量池是为了避免频繁的创建和销毁对象而影响系统性能，其实现了对象的共享。
     * Java的自动装箱中其实就使用到了运行时常量池
     *
     * 字符串进入到常量池的两种方法：

     1. new String()的实例调用intern()方法。
         执行intern()方法时，若常量池中不存在等值的字符串，JVM就会在常量池中 创建一个等值的字符串，然后返回该字符串的引用。
     2. “”（引号）引起来的内容（字面量）。
         引号引起来的字符串，首先从常量池中查找是否存在此字符串，如果不存在则在常量池中添加此字符串对象，然后引用此字符串对象。如果存在，则直接引用此字符串。

     重要提示：虚拟机启动时常量池中就存在“java”字符串实例，下面代码中s2调用intern()方法时，只是返回常量池中“java”实例的引用，而没有添加“java”实例。

     *
     * @param args
     */

    public static void main(String[] args) {
        String ss1 = "123";
        String ss2 = "123";
        String ss3 = new String("123");
        String ss4 = new StringBuilder("1").append("23").toString();
        System.out.println(ss1 == ss2);
        System.out.println(ss3 == ss3.intern());
        System.out.println(ss4 == ss1);
//        String s1 = new StringBuilder().append("aa").append("bb").toString();
//        System.out.println(s1.intern() == s1);
//        String s2 = new StringBuilder().append("ja").append("va").toString();
//        System.out.println(s2.intern() == s2);
    }
}
