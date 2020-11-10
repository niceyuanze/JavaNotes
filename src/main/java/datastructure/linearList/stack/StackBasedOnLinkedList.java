package datastructure.linearList.stack;

import datastructure.linearList.linkedList.Node;

public class StackBasedOnLinkedList<T> {
    private Node<T> head;

    private int size = 0;

    public boolean push(T item){
        if(head == null){
            head = new Node<>(item);
            size++;
        }else{
            Node<T> newNode = new Node<>(item);
            newNode.setPrev(head);
            head.setNext(newNode);
            head = newNode;
            size++;
        }
        return true;
    }
    public T pop(){
        if(head == null){
            return null;
        }
        T result = head.getData();
        if(head.getPrev() != null){
            head.getPrev().setNext(null);
        }
        head = head.getPrev();
        return null;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node current = head;
        stringBuffer.append("top:");
        while( current != null){
            stringBuffer.append(current.getData());
            current = current.getPrev();
        }
        stringBuffer.append(":buttom");
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList<Integer> stackBasedOnLinkedList = new StackBasedOnLinkedList<>();
        System.out.println(stackBasedOnLinkedList);
        stackBasedOnLinkedList.pop();
        System.out.println(stackBasedOnLinkedList);
        stackBasedOnLinkedList.push(1);
        System.out.println(stackBasedOnLinkedList);
        stackBasedOnLinkedList.push(2);
        System.out.println(stackBasedOnLinkedList);
        stackBasedOnLinkedList.push(3);
        System.out.println(stackBasedOnLinkedList);
        stackBasedOnLinkedList.pop();
        System.out.println(stackBasedOnLinkedList);
        stackBasedOnLinkedList.pop();
        System.out.println(stackBasedOnLinkedList);
        stackBasedOnLinkedList.pop();
        System.out.println(stackBasedOnLinkedList);
        stackBasedOnLinkedList.pop();
        System.out.println(stackBasedOnLinkedList);
    }
}
