package datastructure.sort;

import datastructure.util.ArrayUtil;

import java.util.Arrays;

public class CountingSort {

//    计数排序中可以从头向后取数据吗？个人感觉似乎是一样的过程。可以的 但就不是稳定排序算法了




    public static void sort(int[] input){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int each: input){
            if(each < min){
                min = each;
            }
            if(each > max){
                max = each;
            }
        }
        int distance = max - min;
//        计数排序上下界差距太大，不使用计数排序，采用快排
        if( distance > 1000){
            Arrays.sort(input);
            return ;
        }
        System.out.println("进入快排");

        int[] tmp = new int[ distance + 1];
        for(int each: input){
            tmp[each - min]++;
        }
        int index = 0;
        for(int i = 0; i < tmp.length;i++){
            while(tmp[i]-- > 0){
               input[index++] = i+min;
            }
        }



    }

    public static void main(String[] args) {
        int[] input = new int[]{4,5,3,6,2,5,1};
        sort(input);
        System.out.println(ArrayUtil.dump(input));
    }
}
