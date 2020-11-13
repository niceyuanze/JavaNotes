package datastructure.recursion;

public class OneStepOrTwoStap {

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
        return getStapsInRecursion(n-1) + getStapsInRecursion(n-2);
    }

    public static void main(String[] args) {
        System.out.println(getStapsInRecursion(10));
    }
}
