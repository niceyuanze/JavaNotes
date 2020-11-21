package datastructure.search;

public class BinarySearch {
    public static <T extends Comparable> int simplestBinarySearchNonRecursion(T[] input, T value){

        int left = 0;
        int right = input.length;
        int mid = 0;
        while(left <= right){
//            ÓÅ»¯Ð´·¨ mid = left + ((right - left ) >> 1 )
            mid = (left+right ) / 2;
            if( input[mid].equals(value)){
                return mid;
            } else if( input[mid].compareTo(value) > 0){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,4,5,6};
        System.out.println(simplestBinarySearchNonRecursion(input,1));
        System.out.println(simplestBinarySearchNonRecursion(input,2));
        System.out.println(simplestBinarySearchNonRecursion(input,3));
        System.out.println(simplestBinarySearchNonRecursion(input,4));
        System.out.println(simplestBinarySearchNonRecursion(input,5));
        System.out.println(simplestBinarySearchNonRecursion(input,6));



    }


}
