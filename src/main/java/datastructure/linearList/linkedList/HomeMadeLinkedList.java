package datastructure.linearList.linkedList;

public class HomeMadeLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    public void put(T input){
        if (head == null){
            head = new Node<>(input);
            tail = head;
        } else{

            Node node = new Node(input);
            tail.setNext(node);
            tail = node;
        }
    }
}
