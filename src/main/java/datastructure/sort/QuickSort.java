package datastructure.sort;

import datastructure.util.ArrayUtil;

public class QuickSort {
    public static <T> void sort(T[] input,int left, int right){
        if(left >= right){
            return ;
        }

        T pivot = input[right - 1];
        int partition = 0;
        for(int i  = 0; i < right - 1 ;i++ ){
            if( ((Comparable)input[i]).compareTo(pivot) <= 0){
                swap(input,i,partition);
                partition++;
            }
        }
        swap(input,partition,right - 1);
        System.out.println(input);

        sort(input,left,partition);
        sort(input, partition +1,right);

    }

    private static <T> void swap(T[] input, int i, int j){
        T tmp = input[i];
        input[i]= input[j];
        input[j] = tmp;

    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{6,11,3,9,8};
        sort(input,0, input.length);
        System.out.println(ArrayUtil.dump(input));
    }

}
