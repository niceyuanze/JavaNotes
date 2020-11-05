package datastructure.linearList.linkedList;

import java.util.LinkedList;

public class SortLinkedListMerge {
    public static void main(String[] args) {
        HomeMadeSinglySortLinkedList<Integer> homeMadeSinglySortLinkedList1 = new HomeMadeSinglySortLinkedList<>();
        homeMadeSinglySortLinkedList1.insert(0);
        homeMadeSinglySortLinkedList1.insert(3);
        homeMadeSinglySortLinkedList1.insert(5);
        HomeMadeSinglySortLinkedList homeMadeSinglySortLinkedList2 = new HomeMadeSinglySortLinkedList<>();
        homeMadeSinglySortLinkedList2.insert(-1);
        homeMadeSinglySortLinkedList2.insert(3);
        homeMadeSinglySortLinkedList2.insert(4);
        homeMadeSinglySortLinkedList1.merge(homeMadeSinglySortLinkedList2);
        System.out.println(homeMadeSinglySortLinkedList1);

        LinkedList linkedList = new LinkedList();


    }
}
