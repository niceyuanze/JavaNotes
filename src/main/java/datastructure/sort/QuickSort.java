package datastructure.sort;

import datastructure.util.ArrayUtil;

public class QuickSort {




    private static <T> void innerSort(T[] input,int left, int right){
        if(left >= right - 1){
            return ;
        }
// 这个位置有bug，i设置的有问题
        T pivot = input[right - 1];
        int partition = 0;
        for(int i  = left; i < right - 1 ;i++ ){
            if( ((Comparable)input[i]).compareTo(pivot) <= 0){
                swap(input,i,partition);
                partition++;
            }
        }
        swap(input,partition,right - 1);

        innerSort(input,left,partition);
        innerSort(input, partition +1,right);

    }

    private static <T> void innerSortII(T[] input,int left, int right){
        if(left >= right){
            return ;
        }
// 这个位置有bug，i设置的有问题
        T pivot = input[right];
        int partition = 0;
//        这个地方无效循环可以加一个if避免一下
        for(int i  = left; i < right ;i++ ){
            if( ((Comparable)input[i]).compareTo(pivot) <= 0){
                swap(input,i,partition);
                partition++;
            }
        }
        swap(input,partition,right);

        innerSortII(input,left,partition - 1);
        innerSortII(input, partition +1,right);

    }

    private static <T> void swap(T[] input, int i, int j){
        T tmp = input[i];
        input[i]= input[j];
        input[j] = tmp;

    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{6,1,3,5};
        innerSortII(input,0, input.length - 1);
        System.out.println(ArrayUtil.dump(input));
    }

}
