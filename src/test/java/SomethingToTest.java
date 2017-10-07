import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by niceyuanze on 17-6-2.
 */
public class SomethingToTest {
    public static void main(String[] args) {
        LocalDate localDate  = LocalDate.now();
        System.out.println(localDate.getYear());
        System.out.println(localDate);
        String test = "25";
        System.out.println(test.split("-"));
        Arrays.stream(test.split("-")).forEach(x -> System.out.println(x));











    }
    @Test
    public void testAnnotation(){
        int[] x = new int[3];
        System.out.println(x.length);

    }
}
