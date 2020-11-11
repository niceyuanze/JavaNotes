package datastructure.linearList.queue;

import datastructure.linearList.linkedList.Node;

public class QueueBasedOnLinkedList<T> {

    private Node<T> head;

    private Node<T> tail;

    private int max = 0;

    private int size = 0;

    public QueueBasedOnLinkedList() {
        max = 5;
    }
    public boolean enQueue(T item){
        if( size == max){
            return false;
        } else{
            Node newNode = new Node(item);
            if (size == 0){
                head = newNode;
                head.setNext(tail);
                tail = newNode;
            } else{
                tail.setNext(newNode);
                tail = newNode;
            }
            size++;
            return true;
        }
    }
    public T deQueue(){
        if( size == 0){
            return null;
        }
        size--;
        Node<T> tmp = head;
        head = head.getNext();
        return tmp.getData();
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        Node current = head;
        while(current != null){
            s.append(current.getData());
            current = current.getNext();
        }
        return s.toString();
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList<Integer> queueBasedOnLinkedList = new QueueBasedOnLinkedList<>();
        System.out.println(queueBasedOnLinkedList);
        queueBasedOnLinkedList.enQueue(1);
        System.out.println(queueBasedOnLinkedList);
        queueBasedOnLinkedList.enQueue(2);
        System.out.println(queueBasedOnLinkedList);
        queueBasedOnLinkedList.enQueue(3);
        System.out.println(queueBasedOnLinkedList);
        queueBasedOnLinkedList.deQueue();
        System.out.println(queueBasedOnLinkedList);
        queueBasedOnLinkedList.deQueue();
        System.out.println(queueBasedOnLinkedList);
        queueBasedOnLinkedList.deQueue();
        System.out.println(queueBasedOnLinkedList);
    }
}
