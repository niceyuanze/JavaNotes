package datastructure.recursion;

public class Movie {
//    F(n) = F(n-1) + 1
    /*
    * F(n) = F(n-1) + 1
    * F(1) = 1
    * */
    public static int getNowRecursion(int n){
        if(n < 1){
            return 0;
        }
        if( n == 1){
            return 1;
        }
        return getNowRecursion(n - 1,0)+1;
    }
    public static int getNowRecursion(int n,int depth ){
        if(depth > 50){
            System.out.println("Õ»±¬Õ¨");
            throw new RuntimeException();
        }
        if(n < 1){
            return 0;
        }
        if( n == 1){
            return 1;
        }
        depth++;
        return getNowRecursion(n - 1,depth)+1;
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
