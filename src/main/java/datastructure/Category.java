package datastructure;


public class Category {
// todo
//    https://github.com/wangzheng0822/algo/blob/master/java/07_linkedlist/LinkedListAlgo.java
//    todo ，浏览器前进后退双栈,四则混合预算
//    阻塞队列，并发安全队列
//    递归，检查环的存在
//    sout 小于栈异常，这个要研究一下
//
//    排序性能比较

//    课后思考我们讲过，特定算法是依赖特定的数据结构的。我们今天讲的几种排序算法，都是基于数组实现的。
//    如果数据存储在链表中，这三种排序算法还能工作吗？如果能，那相应的时间、空间复杂度又是多少呢？
//    欢迎留言和我分享，我会第一时间给你反馈。
//    如何在 O(n) 的时间复杂度内查找一个无序数组中的第 K 大元素？
//    希尔排序 https://github.com/wangzheng0822/algo/blob/master/java/11_sorts/SortsAddOn.java
//    第k大元素
//    哨兵归并排序
//    修复快排bug
//    快排递归非递归写法
//    黄金分隔查找法
//    循环有序数组 思考题 还需思考思考，目前我写的版本要求对所有元素都是唯一，如何查找有重复的元素这个还需完善 查找第一个等于target的元素
//    插入排序二分查找优化
//    跳表继续品




//    done
//    第k大元素
//    java1.8中的排序，在元素小于47的时候用插入排序，大于47小于286用双轴快排，大于286用timsort归并排序，
//    并在timesort中记录数据的连续的有序段的的位置，若有序段太多，也就是说数据近乎乱序，则用双轴快排，当然快
//    排的递归调用的过程中，若排序的子数组数据数量小，用插入排序。
//



    /**
     *
     * 今天的IP地址归属地问题，从工程实现的角度考虑，我更偏向于直接使用关系型数据库实现。
     * 也就是将12w条归属地与IP区间的开始、结束存入数据库中。
     * 数据库表ip_table有如下字段：area_name | start_ip | end_ip ，start_ip及end_ip 均建立索引
     * SQL语句：
     * select area_name from ip_table where input_ip >= start_ip and input_ip <= end_ip;
     * 学习算法的课程常常和自己工程开发的实际结合在一起，感觉两者是相互促进理解的过程。
     * */



    public static void main(String[] args) {


        throw new RuntimeException();
    }

}
