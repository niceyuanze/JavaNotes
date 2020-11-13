package datastructure.recursion;

import java.util.HashMap;
import java.util.Map;

public class OneStepOrTwoStap {

    private static Map<Integer,Integer> cache = new HashMap<>();
    static {
        cache.put(1,1);
        cache.put(2,2);
    }


//    F(n) = F(n-1)+ F(n-2)
//    F
    /*
    * F(n) = F(n-1)+ F(n-2)
    * F(1) = 1;
    * F(2) = 2;
    * */
    public static int getStapsInRecursion(int n){
        return getStapsInRecursion(n,0);
    }
    private static int getStapsInRecursion(int n,int depth){
        if(n < 1){
            return 0;
        }
        if(n < 3){
            return n;
        }

        int curr;
        if(cache.get(n) != null){
            curr = cache.get(n);
        }else{
            curr =getStapsInRecursion(n-1) + getStapsInRecursion(n-2);
            cache.put(n,curr);
        }
        return curr;
    }
    public static int getStapsNonRecursion(int n){
        int pre = 2;
        int prepre = 1;
        int result = 0;
        for(int i =3; i <= n; i++){
            result= pre + prepre;
            prepre =pre;
            pre = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getStapsInRecursion(10));
        System.out.println(getStapsNonRecursion(10));
    }
}
