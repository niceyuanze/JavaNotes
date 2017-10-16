package fundamental;

import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) {
        List<? extends Number> foo3 = new ArrayList<? extends Number>();

// Integer extends Number

//        List<? extends Number> foo3 = new ArrayList<? extends Integer>();

// Double extends Number

//        List<? extends Number> foo3 = new ArrayList<? extends Double>();




    }
}
