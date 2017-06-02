![Alt text](/home/niceyuanze/Downloads/javaNotes/img/jdk7jdk8StringConstantPool.png)
如图中，我们可以看到常量池位于方法区（PermGen），但常量池引用的字符串实例在堆中。（区别在这）
1. 通过调用intern()方法，会在常量池添加一个此字符串实例的引用，（前提：常量池中没有相同内容的字符串）。
2. “”内的字符串实例引用会添加到常量池中（前提：常量池中没有相同内容的字符串），如果常量池中存在，则引用常量池中的对象（防止重复创建对象）。

根据上图内存模型然后我们在分析下代码：
String s1 = new StringBuilder().append(“aa”).append(“bb”).toString();
System.out.println(s1.intern() == s1);
s1生成的对象在堆中，此时常量池中没有跟s1内容相同的字符串，所以在调用intern方法时，会在常量池中添加此对象的引用，所以返回为true。

String s2 = new StringBuilder().append(“ja”).append(“va”).toString();
System.out.println(s2.intern() == s2);
s2生成的对象在堆中，而此时常量池中已经有一个跟s2内容相同的字符串常量，当s2调用intern方法时，返回常量池中已经存在的实例（相当于堆中有两个相同内容的实例：一个是new 出来的，一个是常量池中的）所以返回的结果为false。
![Alt text](/home/niceyuanze/Downloads/javaNotes/img/jdk6StringConstantPool.png)
如图中，我们可以看到常量池位于方法区（PermGen），常量池中引用的字符串实例也在常量池中。
1、通过调用intern()方法，会在常量池中生成一个相同字符串的对象
2、“”内的字符串都会添加到常量池中，相当于引用的方法区中的字符串对象。

根据上图内存模型然后我们在分析下代码：

String s1 = new StringBuilder().append(“aa”).append(“bb”).toString();
System.out.println(s1.intern() == s1);
s1生成的对象在堆中，而s1.intern()的对象在常量池中，所以返回false。

String s2 = new StringBuilder().append(“ja”).append(“va”).toString();
System.out.println(s2.intern() == s2);
s2生成的对象在堆中，而s2.intern()的对象也肯定在常量池中，所以也返回false。