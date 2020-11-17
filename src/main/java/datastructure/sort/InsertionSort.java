package datastructure.sort;

import datastructure.util.ArrayUtil;

public class InsertionSort {

    public static <T extends Comparable> void sort(T[] input){
        for( int i = 0; i < input.length - 1; i++){
            int j = i + 1;
            T curr = input[j];
            for(; j>0  &&  curr.compareTo(input[j-1]) < 0;j--){
                input[j] = input[j-1];
            }
            input[j] = curr;
        }
    }

    // ��������a��ʾ���飬n��ʾ�����С
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // ���Ҳ����λ��
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // �����ƶ�
                } else {
                    break;
                }
            }
            a[j+1] = value; // ��������
        }
    }

    /**
     * ��ѯ����λ��ʱ�� ��ͷ��β����
     * @param data
     */
    private static void fromStartToEnd(int[] data) {
        for (int i=1; i < data.length; i++) {
            int value = data[i];

            int[] tmp = new int[2];
            int change = i;
            for (int j=0; j < i; j++) {
                if(value >= data[j]) {
                    continue;
                }

                int index = j%2;
                if (change == i) {
                    tmp[Math.abs(index-1)] = data[j];
                    change = j;
                }
                tmp[index] = data[j+1];
                if (0 == index) {
                    data[j+1] = tmp[index+1];
                } else {
                    data[j+1] = tmp[index-1];
                }
            }
            data[change] = value;
        }
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4,5,3,6,4,5,1};
//        Integer[] input = new Integer[]{5,4};

        sort(input);
        System.out.println(ArrayUtil.dump(input));
    }
}
