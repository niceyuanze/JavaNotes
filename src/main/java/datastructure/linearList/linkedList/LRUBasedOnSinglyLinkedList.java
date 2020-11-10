package datastructure.linearList.linkedList;

public class LRUBasedOnSinglyLinkedList<T> {

    private Node<T> head;

    private int size = 0;

    private int max = 0;

    public LRUBasedOnSinglyLinkedList() {
        this.max = 3;
    }

    public boolean add(T data){
        Node<T> cache = find(data);
        if(cache == null){
            Node<T> newNode = new Node<>(data);
            newNode.setNext(head);
            head = newNode;
            if(size == max){
                Node<T> current = head;
                for(int i = 1; i < max;i++){
                    current = current.getNext();

                }
                current.setNext(null);
            }
        }else{
            Node current = head;

            while(!(current == cache) && !(current.getNext() == cache)){
                current = current.getNext();
            }
            if(current == cache){

            }else if(current.getNext() == cache){
                current.setNext(cache.getNext());
                cache.setNext(head);
                head = cache;
            }else{
                return false;
            }
        }
        size++;
        return true;
    }

    public Node<T> find(T data){
        Node<T> current = head;
        while(current != null && !current.getData().equals(data)){
            current = current.getNext();
        }
        return current == null || current.getData().equals(data) ? current: null;
    }


    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        Node<T> current = head;
        while(current!=null){
            s.append(current.getData());
            current = current.getNext();
        }
        return s.toString();
    }

    public static void main(String[] args) {
        LRUBasedOnSinglyLinkedList lruBasedOnSinglyLinkedList = new LRUBasedOnSinglyLinkedList();
        System.out.println(lruBasedOnSinglyLinkedList);
        lruBasedOnSinglyLinkedList.add(1);
        System.out.println(lruBasedOnSinglyLinkedList);
        lruBasedOnSinglyLinkedList.add(2);
        System.out.println(lruBasedOnSinglyLinkedList);
        lruBasedOnSinglyLinkedList.add(3);
        System.out.println(lruBasedOnSinglyLinkedList);
        lruBasedOnSinglyLinkedList.add(4);
        System.out.println(lruBasedOnSinglyLinkedList);
        lruBasedOnSinglyLinkedList.add(2);
        System.out.println(lruBasedOnSinglyLinkedList);
    }
}
