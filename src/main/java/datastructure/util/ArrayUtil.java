package datastructure.util;

public class ArrayUtil {

    public static <T> T[] grow(T[] origin){
        if(origin == null || origin.length == 0){
            return origin;
        }
        T[] newArray = (T[]) new Object[origin.length * 2];
        for(int i = 0; i < origin.length;i++){
            newArray[i] = origin[i];
        }
        return newArray;
    }
    public static <T> String dump(T[] input){
        StringBuffer s = new StringBuffer();
        for(T each: input){
            s.append(each);
        }
        return s.toString();
    }
}
