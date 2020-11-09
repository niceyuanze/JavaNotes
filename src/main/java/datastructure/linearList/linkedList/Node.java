package datastructure.linearList.linkedList;

public class Node<T> {

    private T data;
    private Node next;

    private Node prev;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node(T data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return ""+data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
