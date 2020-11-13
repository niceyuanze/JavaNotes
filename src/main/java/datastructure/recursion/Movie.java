package datastructure.recursion;

public class Movie {
//    F(n) = F(n-1) + 1
    public static int getNowRecursion(int n){
        if(n < 1){
            return 0;
        }
        if( n == 1){
            return 1;
        }
        return getNowRecursion(n - 1,0)+1;
    }
    public static int getNowRecursion(int n,int deepth ){
        if(deepth > 50){
            System.out.println("Õ»±¬Õ¨");
            throw new RuntimeException();
        }
        if(n < 1){
            return 0;
        }
        if( n == 1){
            return 1;
        }
        deepth++;
        return getNowRecursion(n - 1,deepth)+1;
    }
    public static int getNowNonRecursion(int n){
        if( n < 1){
            return 0;
        }
        int result = 1;
        for(int i = 2; i <= n;i++){
            result = result+1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getNowRecursion(10));
//        System.out.println(getNowRecursion(58));
        System.out.println(getNowNonRecursion(10));

    }
}
