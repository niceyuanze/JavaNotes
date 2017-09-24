package path;

public class ClassPath {


    public void test(){
        System.out.println(this.getClass().getClassLoader().getResource("").getPath());

    }

    public static void main(String[] args) {
        ClassPath classPath = new ClassPath();
        classPath.test();
    }
}
