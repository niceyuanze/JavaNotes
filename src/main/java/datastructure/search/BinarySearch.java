package datastructure.search;

public class BinarySearch {
    public static <T extends Comparable> int simplestBinarySearchNonRecursion(T[] input, T value){

        int left = 0;
        int right = input.length - 1;
        int mid = 0;
        while(left <= right){
//            优化写法 mid = left + ((right - left ) >> 1 )
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


    public static <T extends Comparable<T>> int firstValueBinarySearchNonRecursion(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if( input[mid].equals(value)){
                while(mid > 0 && input[mid-1].equals(value)){
                    mid--;
                }
                return mid;
            } else if( input[mid].compareTo(value) > 0){
                right = mid - 1;
            } else if( input[mid].compareTo(value) < 0){
                left = mid + 1;

            }
        }
        return -1;
    }
    public static <T extends Comparable<T>> int lastValueBinarySearchNonRecursion(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if( input[mid].equals(value)){
                while(mid < input.length - 1 && input[mid+1].equals(value)){
                    mid++;
                }
                return mid;
            } else if( input[mid].compareTo(value) > 0){
                right = mid - 1;
            } else if( input[mid].compareTo(value) < 0){
                left = mid + 1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("最简单二分查找测试");
        Integer[] input = new Integer[]{1,2,3,4,5,6};
        System.out.println(simplestBinarySearchNonRecursion(input,1));
        System.out.println(simplestBinarySearchNonRecursion(input,2));
        System.out.println(simplestBinarySearchNonRecursion(input,3));
        System.out.println(simplestBinarySearchNonRecursion(input,4));
        System.out.println(simplestBinarySearchNonRecursion(input,5));
        System.out.println(simplestBinarySearchNonRecursion(input,6));
        System.out.println(simplestBinarySearchNonRecursion(input,7));
        System.out.println("第一个位置二分查找测试");
        input = new Integer[]{1,1,2,2,3,3};
        System.out.println(firstValueBinarySearchNonRecursion(input,1));
        System.out.println(firstValueBinarySearchNonRecursion(input,2));
        System.out.println(firstValueBinarySearchNonRecursion(input,3));
        System.out.println(firstValueBinarySearchNonRecursion(input,4));
        System.out.println(firstValueBinarySearchNonRecursion(input,5));
        System.out.println(firstValueBinarySearchNonRecursion(input,6));
        System.out.println(firstValueBinarySearchNonRecursion(input,7));
        System.out.println("第一个位置二分查找测试");
        System.out.println(lastValueBinarySearchNonRecursion(input,1));
        System.out.println(lastValueBinarySearchNonRecursion(input,2));
        System.out.println(lastValueBinarySearchNonRecursion(input,3));
        System.out.println(lastValueBinarySearchNonRecursion(input,4));
        System.out.println(lastValueBinarySearchNonRecursion(input,5));
        System.out.println(lastValueBinarySearchNonRecursion(input,6));
        System.out.println(lastValueBinarySearchNonRecursion(input,7));


    }


}
