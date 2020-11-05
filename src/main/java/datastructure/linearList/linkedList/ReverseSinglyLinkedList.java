package datastructure.linearList.linkedList;

public class ReverseSinglyLinkedList {
    public static void main(String[] args) {
        HomeMadeSinglyLinkedList<Integer> homeMadeSinglyLinkedList = new HomeMadeSinglyLinkedList<>();
        homeMadeSinglyLinkedList.put(1);
        homeMadeSinglyLinkedList.put(2);
        homeMadeSinglyLinkedList.put(3);
        System.out.println(homeMadeSinglyLinkedList);
        homeMadeSinglyLinkedList.reverseNonInplace();
        System.out.println(homeMadeSinglyLinkedList);
        homeMadeSinglyLinkedList.reverseInplace();
        System.out.println(homeMadeSinglyLinkedList);
        homeMadeSinglyLinkedList.reverseInplace();
        System.out.println(homeMadeSinglyLinkedList);



    }
}
