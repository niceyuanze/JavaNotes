package datastructure.linearList.linkedList;

public class Test {
    public static void main(String[] args) {
        HomeMadeSinglyLinkedList<Integer> homeMadeSinglyLinkedList = new HomeMadeSinglyLinkedList<>();
        homeMadeSinglyLinkedList.put(1);
        homeMadeSinglyLinkedList.put(2);
        homeMadeSinglyLinkedList.put(3);
        homeMadeSinglyLinkedList.put(4);
        System.out.println(homeMadeSinglyLinkedList.getMiddle());
        System.out.println(homeMadeSinglyLinkedList);
        homeMadeSinglyLinkedList.deleteNth(2);
        System.out.println(homeMadeSinglyLinkedList);

    }
}
