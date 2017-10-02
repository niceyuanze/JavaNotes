package fundamental;

import model.One;
import model.Two;

public class StudyObject {
    public static void main(String[] args) {
        Number n = 0;
        Class<? extends Number> c = n.getClass();
        Class cc = n.getClass();
        System.out.println(c);
        System.out.println(cc);

        One one = new One();
        one.setTwo(new Two());
//

    }
}
