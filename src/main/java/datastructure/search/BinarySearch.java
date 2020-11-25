package datastructure.search;

public class BinarySearch {
    public static <T extends Comparable> int simplestBinarySearchNonRecursion(T[] input, T value,int inputLeft, int inputRight){

        int left = inputLeft;
        int right = inputRight;
        int mid = 0;
        while(left <= right){
//            �Ż�д�� mid = left + ((right - left ) >> 1 )
            mid = (left+right ) / 2;
            if( input[mid].equals(value)){
                return mid;
            } else if( input[mid].compareTo(value) > 0){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return -1;
    }


    public static <T extends Comparable<T>> int firstValueBinarySearchNonRecursion(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if( input[mid].equals(value)){
//                �������Ż�����ע�͵����д����̫�� while(mid > 0 && input[mid-1].equals(value)){
//                    mid--;
//                }
                if(mid == 0 || !input[mid - 1].equals(value)){
                    return mid;
                }else{
                    right = mid - 1;
                }
            } else if( input[mid].compareTo(value) > 0){
                right = mid - 1;
            } else if( input[mid].compareTo(value) < 0){
                left = mid + 1;

            }
        }
        return -1;
    }
    public static <T extends Comparable<T>> int lastValueBinarySearchNonRecursion(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if( input[mid].equals(value)){
//                while(mid < input.length - 1 && input[mid+1].equals(value)){
//                    mid++;
//                }
                if(mid == input.length - 1 || !input[mid + 1].equals(value)){
                    return mid;
                }
                left = mid + 1;
            } else if( input[mid].compareTo(value) > 0){
                right = mid - 1;
            } else if( input[mid].compareTo(value) < 0){
                left = mid + 1;

            }
        }
        return -1;
    }


    /**
    *
    * �����ַ�������ѭ����������
     *
     *  һ��
     *  1. �ҵ��ֽ��±꣬�ֳ�������������
     *  2. �ж�Ŀ��ֵ���ĸ��������ݷ�Χ�ڣ������ֲ���
     *
     *  ����
     *  1. �ҵ����ֵ���±� x;
     *  2. ����Ԫ���±� +x ƫ�ƣ��������鷶Χֵ��ȡģ;
     *  3. ����ƫ�ƺ���±������ֲ��ң�
     *  4. ����ҵ�Ŀ���±꣬���� -x ƫ�ƣ�����Ŀ��ֵʵ���±ꡣ
     *
     *  ����������ʱ�Ķ��ڲ��ҷֽ���ϣ�����ʱ�临�Ӷ��� O(N����
     *
     *  ���Ӷ��е�ߣ��ܷ��Ż��أ�
     *
     *  ����
     * ���Ƿ���ѭ���������һ�����ʣ��������м��Ϊ�������Ὣ����ֳ�һ�����������һ��ѭ���������顣
     *
     *  �����Ԫ��С�� mid��˵��ǰ�벿��������ģ���벿����ѭ���������飻
     *  �����Ԫ�ش��� mid��˵����벿��������ģ�ǰ�벿����ѭ����������飻
     *  ���Ŀ��Ԫ�����������鷶Χ�У�ʹ�ö��ֲ��ң�
     *  ���Ŀ��Ԫ����ѭ�����������У��趨����߽��ʹ�����Ϸ����������ҡ�
     *
     *  ʱ�临�Ӷ�Ϊ O(logN)��
    * */
//  https://leetcode.com/problems/search-in-rotated-sorted-array/
//    ѭ��������������ʣ�����ѡ�����е�һ��index��0 - index , index-end��������һ��������һ���������
    public static <T extends Comparable<T>> int cycleArrayBinarySearch(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid ;
        while( left <= right){
            mid = left + (right - left) / 2;
            if(input[mid].compareTo(value) == 0){
                return mid;
            }
//            left -> mid �������
            if(input[left].compareTo(input[mid]) <= 0){
//                Ԫ�صķ�Χ��left��mid��
                if(input[mid].compareTo(value) > 0 && input[left].compareTo(value) <= 0){
                    right = mid - 1;
//                    ���ڣ�ȥ�����������Ѱ��
                } else {
                    left = mid + 1;
                }
//                mid -> end�������
            }else{
//                target ��mid��left��Χ��
                if( input[mid].compareTo(value) < 0 && input[right].compareTo(value) >= 0){
                    left = mid + 1;
//                    ���ڣ�ȥ����������
                }else{
                    right = mid -1;
                }

            }
        }
        return -1;
    }


    public static <T extends Comparable<T>> int firstBiggerEqualValueBinarySearchNonRecursion(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid;
        int pre = -1;
//        ����֮ǰ�ҵ�д��while( left <= right){
//            mid = left + ((right - left) >> 2);
//            if( input[mid].equals(value) || input[mid].compareTo(value) > 0){
//                pre = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }

        while( left <= right){
            mid = left + (right - left) / 2;
            if(input[mid].equals(value) || input[mid].compareTo(value) > 0){
                if(mid == 0 || input[mid - 1].compareTo(value) < 0){
                    return mid;
                }
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return pre;
    }


    public static <T extends Comparable<T>> int lastLessEqualValueBinarySearchNonRecursion(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid;
        while ( left <= right){
            mid = left + (right - left) / 2;
            if( input[mid].compareTo(value) <= 0){
                if(mid == input.length - 1 || input[mid+1].compareTo(value) > 0){
                    return mid;
                }
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int firstLessEqualValueBinarySearchNonRecursion(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid;
        int pre = -1;
        while( left <= right){
            mid = left + ((right - left) >> 2);
            if( input[mid].equals(value)){
                return 0;
            } else if( input[mid].compareTo(value) < 0){
                return 0;
            } else{
                right = mid - 1;
            }
        }
        return pre;

    }

    public static void main(String[] args) {
        System.out.println("��򵥶��ֲ��Ҳ���");
        Integer[] input = new Integer[]{1,2,3,4,5,6};
        System.out.println(simplestBinarySearchNonRecursion(input,1,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,2,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,3,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,4,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,5,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,6,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,7,0,5));
        System.out.println("��һ��λ�ö��ֲ��Ҳ���");
        input = new Integer[]{1,1,2,2,3,3};
        System.out.println(firstValueBinarySearchNonRecursion(input,1));
        System.out.println(firstValueBinarySearchNonRecursion(input,2));
        System.out.println(firstValueBinarySearchNonRecursion(input,3));
        System.out.println(firstValueBinarySearchNonRecursion(input,4));
        System.out.println(firstValueBinarySearchNonRecursion(input,5));
        System.out.println(firstValueBinarySearchNonRecursion(input,6));
        System.out.println(firstValueBinarySearchNonRecursion(input,7));
        System.out.println("���һ��λ�ö��ֲ��Ҳ���");
        System.out.println(lastValueBinarySearchNonRecursion(input,1));
        System.out.println(lastValueBinarySearchNonRecursion(input,2));
        System.out.println(lastValueBinarySearchNonRecursion(input,3));
        System.out.println(lastValueBinarySearchNonRecursion(input,4));
        System.out.println(lastValueBinarySearchNonRecursion(input,5));
        System.out.println(lastValueBinarySearchNonRecursion(input,6));
        System.out.println(lastValueBinarySearchNonRecursion(input,7));
        System.out.println("��һ�����ڵ���λ�ö��ֲ��Ҳ���");
        input = new Integer[]{1,3,5,6,9};
        System.out.println(firstBiggerEqualValueBinarySearchNonRecursion(input,2));
        System.out.println("���һ��С�ڵ���λ�ö��ֲ��Ҳ���");
        input = new Integer[]{1,3,5,6,9};
        System.out.println(lastLessEqualValueBinarySearchNonRecursion(input,2));
        input = new Integer[]{4,5,0,1,2,3};
        System.out.println("ѭ��������� 4,5,0,1,2,3");
        System.out.println(cycleArrayBinarySearch(input,4));
        System.out.println(cycleArrayBinarySearch(input,5));
        System.out.println(cycleArrayBinarySearch(input,0));
        System.out.println(cycleArrayBinarySearch(input,1));
        System.out.println(cycleArrayBinarySearch(input,2));
        System.out.println(cycleArrayBinarySearch(input,3));
        System.out.println(cycleArrayBinarySearch(input,6));
        System.out.println("ѭ��������� 0,1,2,3,4,5");
        input = new Integer[]{0,1,2,3,4,5};
        System.out.println(cycleArrayBinarySearch(input,0));
        System.out.println(cycleArrayBinarySearch(input,1));
        System.out.println(cycleArrayBinarySearch(input,2));
        System.out.println(cycleArrayBinarySearch(input,3));
        System.out.println(cycleArrayBinarySearch(input,4));
        System.out.println(cycleArrayBinarySearch(input,5));




    }


}
