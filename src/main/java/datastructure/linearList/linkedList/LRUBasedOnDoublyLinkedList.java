package datastructure.linearList.linkedList;

public class LRUBasedOnDoublyLinkedList<T> {

    private Node<T> head;

    private Node<T> tail;


    private int max = 3;

    private int length;

    public LRUBasedOnDoublyLinkedList() {
    }

    public LRUBasedOnDoublyLinkedList(int max) {
        this.max = max;
        LRUBasedOnDoublyLinkedList l = null;

    }

    public void add(T data){
        if( head == null){
            this.head = new Node<>(data);
            return;
        }
        Node findResult = findDataNodeUseLoop(data);
        if( findResult == null){
            Node newNode = new Node(data);
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
            if( length >= max){
                tail.getPrev().setNext(null);
            }
        } else{
            if(findResult.getPrev() != null){
                findResult.getPrev().setNext(findResult.getNext());
                findResult.setNext(this.head);
                findResult.setPrev(null);
                this.head = findResult;
            }
        }
    }
    public Node findDataNodeUseLoop(T data){

        Node current = head;
        while( current != null){
            if(data == null && current.getData() == null){
                return current;
            }
            if(current.getData().equals(data)){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Node findTail(){
        Node tail = head;
        while(tail != null && tail.getNext() != null){
            tail = tail.getNext();
        }
        return tail;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        while( current != null){
            stringBuilder.append(current.getData());
            current = current.getNext();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRUBasedOnDoublyLinkedList<Integer> lruBasedOnDoublyLinkedList = new LRUBasedOnDoublyLinkedList<>();
        lruBasedOnDoublyLinkedList.add(1);
        System.out.println(lruBasedOnDoublyLinkedList);
        lruBasedOnDoublyLinkedList.add(1);
        System.out.println(lruBasedOnDoublyLinkedList);
        lruBasedOnDoublyLinkedList.add(2);
        lruBasedOnDoublyLinkedList.add(3);
        lruBasedOnDoublyLinkedList.add(1);
        System.out.println(lruBasedOnDoublyLinkedList);
        lruBasedOnDoublyLinkedList.add(1);
        System.out.println(lruBasedOnDoublyLinkedList);




    }
}
