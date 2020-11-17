package datastructure.sort;

import datastructure.util.ArrayUtil;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4,5,3,6,4,5,1};
        sort(input);
    }

    public static <T extends Comparable> void sort(T[] input){
        innerSort(input,0, input.length - 1 );
        System.out.println(ArrayUtil.dump(input));
    }

    private  static <T> void innerSort(T[] input, int p, int q ){
        if(p>=q){
            return;
        }
        if(q == p + 1){
            if(( (Comparable<? super T>)input[p]).compareTo(input[q]) > 0){
                T tmp = input[p];
                input[p] = input[q];
                input[q] = tmp;
            }
            return;
        }
        int middle = ( p + q) / 2;
        innerSort(input,p,middle);
        innerSort(input,middle+1,q);

        T[] tmp = (T[]) new Object[q - p + 1];
        int index = 0;
        int left = p;
        int right  = middle + 1;
        for(; left<=middle && right<=q;){
            if(( (Comparable<? super T>)input[left]).compareTo(input[right]) <= 0){
                tmp[index] = input[left];
                left++;
            }else{
                tmp[index] = input[right];
                right++;
            }
            index++;
        }
        while(left <= middle){
            tmp[index] = input[left];
            left++;
            index++;
        }
        while(right <= q){
            tmp[index] = input[right];
            right++;
            index++;
        }
        while (index > 0){
            input[p + index - 1] = tmp[index - 1];
            index--;
        }


    }
}
