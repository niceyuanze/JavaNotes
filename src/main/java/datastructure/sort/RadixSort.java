package datastructure.sort;


import datastructure.util.ArrayUtil;

public class RadixSort {

    public static void radixSort(int[] input){
        int max = Integer.MIN_VALUE;
        for( int each: input){
            if( each > max){
                max = each;
            }
        }

        for( int i = 1; max / i > 0; i *=10){
            sort(input,i);
        }
    }




    public static void sort(int[] input,int exp){
        int[] bucket = new int[10];
        for(int each: input){
            bucket[ (each / exp) % 10]++;
        }
        for(int i = 1; i < bucket.length;i++){
            bucket[i] = bucket[i] + bucket[i-1];
        }
        int[] tmp = new int[input.length];
        for(int i = input.length - 1; i >=0; i--){
            int index = bucket[(input[i] / exp) % 10] - 1;
            tmp[index] = input[i];
            bucket[(input[i] / exp) % 10]--;
        }
        for(int i = 0 ; i < tmp.length;i++){
            input[i] = tmp[i];
        }


    }

    public static void main(String[] args) {
        int[] input = new int[]{134,123,125,};
        radixSort(input);
        System.out.println(ArrayUtil.dump(input));
    }
}
