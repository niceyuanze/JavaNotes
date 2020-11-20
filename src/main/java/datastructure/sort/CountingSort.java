package datastructure.sort;

import datastructure.util.ArrayUtil;

import java.util.Arrays;

public class CountingSort {

//    ���������п��Դ�ͷ���ȡ�����𣿸��˸о��ƺ���һ���Ĺ��̡����Ե� ���Ͳ����ȶ������㷨��




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
//        �����������½���̫�󣬲�ʹ�ü������򣬲��ÿ���
        if( distance > 1000){
            Arrays.sort(input);
            return ;
        }
        System.out.println("�������");

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
