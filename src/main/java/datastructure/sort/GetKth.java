package datastructure.sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import datastructure.util.ArrayUtil;

public class GetKth {
//    left,right,kth均为数组下表，无需+1-1等冗余操作

    public static < T extends Comparable> T getKth( T[] input , int left, int right,int kth){
        T[] clone = input.clone();
        return innergetKth( clone , left,right,kth);
    }

    public static < T extends Comparable> T innergetKth( T[] input , int left, int right,int kth){
        if(left >= right){
            return input[left];
        }
        if( input.length < 2){
            return input[0];
        }
        T pivot = input[right];
        int partition = left;
        for( int i = left; i <= right; i++){
            if(input[i].compareTo(pivot) > 0){
                ArrayUtil.swap( input, partition++,i);
            }
        }
        ArrayUtil.swap(input,partition,right);
        if(partition == kth){
            return input[partition];
        }
        if(partition > kth){
            return getKth(input,left,partition - 1,kth);
        }else{
            return getKth(input,partition + 1,right,kth);
        }
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{6,1,3,5,7,2,4,9,11,8};
//        System.out.println(getKth(input,0,input.length - 1,0));
        System.out.println(getKth(input,0,input.length - 1,0));
        System.out.println(getKth(input,0,input.length - 1,1));
        System.out.println(getKth(input,0,input.length - 1,2));
        System.out.println(getKth(input,0,input.length - 1,3));
        System.out.println(getKth(input,0,input.length - 1,4));
        System.out.println(getKth(input,0,input.length - 1,5));
        System.out.println(getKth(input,0,input.length - 1,6));
        System.out.println(getKth(input,0,input.length - 1,7));
        System.out.println(getKth(input,0,input.length - 1,8));
        System.out.println(getKth(input,0,input.length - 1,9));


    }
}
