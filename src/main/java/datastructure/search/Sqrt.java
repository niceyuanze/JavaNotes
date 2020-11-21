package datastructure.search;

public class Sqrt {

    public static double sqrt(double input,double precision){

        double left = 1.0;
        double right = input;
        double mid;
        int count = 0;

        while(true){
            count++;
            mid = left - ( (left-right) / 2);
            double midSquare = mid * mid;
            if( (midSquare - input) <= precision && (midSquare - input) >= -precision){
                System.out.println(count);
                return mid;
            } else if( (midSquare - input) > precision){
                right = mid;
            } else {
                left = mid;
            }
        }
    //        int precisionNow  = 1;
    //        double left = 0;
    //        double right = input;
    //        double mid = 0;
    //        double distance = 1;
    //        while( left <= mid){
    //            mid = left + ( (left+right) / 2);
    //            double midSquare = mid * mid;
    //            if((int)Math.floor(midSquare) == ){
    //                if (highTmp == input){
    //                    return highTmp;
    //                } else if( lowTmp == input){
    //                    return  lowTmp;
    //                }
    //
    //            } else if()
    //        }
    }

    public static void main(String[] args) {
        System.out.println(sqrt(15,0.00000001));
    }
}
