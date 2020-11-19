package datastructure.sort;

import datastructure.util.ArrayUtil;

import java.util.ArrayList;

public class BucketSort {

    public static <T extends Comparable> void sort(T[] input){
        ArrayList<ArrayList<T>> bucketArrayList = new ArrayList<>(3);
        for(int i = 0 ; i < 3;i++){
            bucketArrayList.add(new ArrayList<>());
        }
        for(T each: input){
            if( each.compareTo(10) < 0){
                bucketArrayList.get(0).add(each);
            } else if( each.compareTo(20) < 0){
                bucketArrayList.get(1).add(each);
            } else{
                bucketArrayList.get(2).add(each);
            }
        }
        bucketArrayList.stream().forEach(eachBucket -> eachBucket.sort( (a,b) -> {return  a.compareTo(b);} ));
        int index = 0 ;
        for(ArrayList<T> eachArrayList: bucketArrayList){
            for(T eachValue: eachArrayList){
                input[index++]= eachValue;
            }
        }
        return ;
    }

    public static void sortII(int[] input,int bucketSize ){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for( int i = 0; i < input.length; i++){
            if( input[i] < min){
                min = input[i];
            }
            if( input[i] > max){
                max = input[i];
            }
        }
        int distance = (int)Math.ceil((max - min) * 1.0/ bucketSize);
        ArrayList<ArrayList<Integer>> bucketArrayList = new ArrayList<>(3);
        for(int i = 0; i < bucketSize; i++){
            bucketArrayList.add(i, new ArrayList<Integer>());
        }
        for(int each: input){
            for(int i = 1; i <= bucketSize;i++){
                if(each <= distance*i+min){
                    bucketArrayList.get((i-1)).add(each);
                    break;
                }
            }
        }
        bucketArrayList.stream().forEach(eachBucket -> eachBucket.sort( (a,b) -> {return  a.compareTo(b);} ));



        int index = 0 ;
        for(ArrayList<Integer> eachArrayList: bucketArrayList){
            for(Integer eachValue: eachArrayList){
                input[index++]= eachValue;
            }
        }
        return ;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{23,7,1,12,29,6,21};
        int[] inputII = new int[]{23,7,1,12,29,6,21};

        sortII(inputII,3);
        System.out.println(ArrayUtil.dump(inputII));
        System.out.println(28/3);


    }
}
