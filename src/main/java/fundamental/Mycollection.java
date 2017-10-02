package fundamental;

import model.One;
import model.Two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/*
    应该是泛型擦除的坑，岳远泽你千万不要删，补完基础回来看



 */
public class Mycollection<T> {

    public  <T> T[] getT1(List<T> t){
        return (T[])t.toArray();
    }

    public static void main(String[] args) {
        Mycollection<One> mycollection = new Mycollection<>();
        List<One> oneList = new ArrayList<One>(Arrays.asList(new One()));
        List<Two> twoList = new ArrayList<Two>(Arrays.asList(new Two()));
//        System.out.println(mycollection.getT1(oneList).length);
        One[] result = (One[])(mycollection.getT1(oneList));
        System.out.println(result);
//        for(Object o: mycollection.getT1(oneList)){
//            System.out.println(o);
//        }
//        System.out.println(mycollection.getT1(oneList));
//        System.out.println(mycollection.getT1(twoList));

        mycollection.getT1(oneList);
    }
}
