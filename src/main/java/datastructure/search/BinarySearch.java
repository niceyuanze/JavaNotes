package datastructure.search;

public class BinarySearch {
    public static <T extends Comparable> int simplestBinarySearchNonRecursion(T[] input, T value,int inputLeft, int inputRight){

        int left = inputLeft;
        int right = inputRight;
        int mid = 0;
        while(left <= right){
//            优化写法 mid = left + ((right - left ) >> 1 )
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
//                下面是优化，被注释的这个写法不太好 while(mid > 0 && input[mid-1].equals(value)){
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
    * 有三种方法查找循环有序数组
     *
     *  一、
     *  1. 找到分界下标，分成两个有序数组
     *  2. 判断目标值在哪个有序数据范围内，做二分查找
     *
     *  二、
     *  1. 找到最大值的下标 x;
     *  2. 所有元素下标 +x 偏移，超过数组范围值的取模;
     *  3. 利用偏移后的下标做二分查找；
     *  4. 如果找到目标下标，再作 -x 偏移，就是目标值实际下标。
     *
     *  两种情况最高时耗都在查找分界点上，所以时间复杂度是 O(N）。
     *
     *  复杂度有点高，能否优化呢？
     *
     *  三、
     * 我们发现循环数组存在一个性质：以数组中间点为分区，会将数组分成一个有序数组和一个循环有序数组。
     *
     *  如果首元素小于 mid，说明前半部分是有序的，后半部分是循环有序数组；
     *  如果首元素大于 mid，说明后半部分是有序的，前半部分是循环有序的数组；
     *  如果目标元素在有序数组范围中，使用二分查找；
     *  如果目标元素在循环有序数组中，设定数组边界后，使用以上方法继续查找。
     *
     *  时间复杂度为 O(logN)。
    * */
//  https://leetcode.com/problems/search-in-rotated-sorted-array/
//    循环有序数组的性质，任意选中期中的一个index，0 - index , index-end两个数组一定至少有一个是有序的
    public static <T extends Comparable<T>> int cycleArrayBinarySearch(T[] input, T value){
        int left = 0;
        int right = input.length - 1;
        int mid ;
        while( left <= right){
            mid = left + (right - left) / 2;
            if(input[mid].compareTo(value) == 0){
                return mid;
            }
//            left -> mid 是有序的
            if(input[left].compareTo(input[mid]) <= 0){
//                元素的范围在left和mid内
                if(input[mid].compareTo(value) > 0 && input[left].compareTo(value) <= 0){
                    right = mid - 1;
//                    不在，去右面的数组中寻找
                } else {
                    left = mid + 1;
                }
//                mid -> end是有序的
            }else{
//                target 在mid与left范围内
                if( input[mid].compareTo(value) < 0 && input[right].compareTo(value) >= 0){
                    left = mid + 1;
//                    不在，去左边数组查找
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
//        这是之前我的写法while( left <= right){
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
        System.out.println("最简单二分查找测试");
        Integer[] input = new Integer[]{1,2,3,4,5,6};
        System.out.println(simplestBinarySearchNonRecursion(input,1,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,2,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,3,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,4,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,5,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,6,0,5));
        System.out.println(simplestBinarySearchNonRecursion(input,7,0,5));
        System.out.println("第一个位置二分查找测试");
        input = new Integer[]{1,1,2,2,3,3};
        System.out.println(firstValueBinarySearchNonRecursion(input,1));
        System.out.println(firstValueBinarySearchNonRecursion(input,2));
        System.out.println(firstValueBinarySearchNonRecursion(input,3));
        System.out.println(firstValueBinarySearchNonRecursion(input,4));
        System.out.println(firstValueBinarySearchNonRecursion(input,5));
        System.out.println(firstValueBinarySearchNonRecursion(input,6));
        System.out.println(firstValueBinarySearchNonRecursion(input,7));
        System.out.println("最后一个位置二分查找测试");
        System.out.println(lastValueBinarySearchNonRecursion(input,1));
        System.out.println(lastValueBinarySearchNonRecursion(input,2));
        System.out.println(lastValueBinarySearchNonRecursion(input,3));
        System.out.println(lastValueBinarySearchNonRecursion(input,4));
        System.out.println(lastValueBinarySearchNonRecursion(input,5));
        System.out.println(lastValueBinarySearchNonRecursion(input,6));
        System.out.println(lastValueBinarySearchNonRecursion(input,7));
        System.out.println("第一个大于等于位置二分查找测试");
        input = new Integer[]{1,3,5,6,9};
        System.out.println(firstBiggerEqualValueBinarySearchNonRecursion(input,2));
        System.out.println("最后一个小于等于位置二分查找测试");
        input = new Integer[]{1,3,5,6,9};
        System.out.println(lastLessEqualValueBinarySearchNonRecursion(input,2));
        input = new Integer[]{4,5,0,1,2,3};
        System.out.println("循环数组查找 4,5,0,1,2,3");
        System.out.println(cycleArrayBinarySearch(input,4));
        System.out.println(cycleArrayBinarySearch(input,5));
        System.out.println(cycleArrayBinarySearch(input,0));
        System.out.println(cycleArrayBinarySearch(input,1));
        System.out.println(cycleArrayBinarySearch(input,2));
        System.out.println(cycleArrayBinarySearch(input,3));
        System.out.println(cycleArrayBinarySearch(input,6));
        System.out.println("循环数组查找 0,1,2,3,4,5");
        input = new Integer[]{0,1,2,3,4,5};
        System.out.println(cycleArrayBinarySearch(input,0));
        System.out.println(cycleArrayBinarySearch(input,1));
        System.out.println(cycleArrayBinarySearch(input,2));
        System.out.println(cycleArrayBinarySearch(input,3));
        System.out.println(cycleArrayBinarySearch(input,4));
        System.out.println(cycleArrayBinarySearch(input,5));




    }


}
