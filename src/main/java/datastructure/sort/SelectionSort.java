package datastructure.sort;

import datastructure.util.ArrayUtil;

public class SelectionSort {
    public static <T extends Comparable> void sort(T[] input){
        for(int i = 0; i < input.length ;i++){
            T min  = input[i];
            int minIndex = i;
            for(int j = i + 1; j < input.length;j++){
                if( input[j].compareTo(min) < 0){
                    min = input[j];
                    minIndex = j;
                }
            }
            T tmp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = min;
        }

    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4,5,3,6,4,5,1};
//        Integer[] input = new Integer[]{5,4};

        sort(input);
        System.out.println(ArrayUtil.dump(input));
    }
}
