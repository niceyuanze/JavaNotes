package datastructure.sort;

import datastructure.util.ArrayUtil;

public class BubbleSort {
    public   static <T extends Comparable<T>>  void sort(T[] input){
        for(int i = 0; i < input.length;i++){
            boolean flag = false;
            for(int j = 0; j < input.length - i -1; j++){
                if( input[j].compareTo(input[j+1]) > 0){
                    T tmp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = tmp;
                    flag = true;

                }
            }
            if(!flag){
                break;
            }
        }

    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4,5,3,6,2,5,1};
        sort(input);
        System.out.println(ArrayUtil.dump(input));

    }
}
