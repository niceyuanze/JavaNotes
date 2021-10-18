package datastructure.linearList.linkedList;

import java.util.HashSet;
import java.util.Set;

public class HomeMadeSinglyLinkedList<T> {

    private Node<T> head;

    private Node<T> tail;

    private int length = 0;

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
        length++;
    }
    public void reverseNonInplace(){
        if( length == 0){
            return;
        }
        Node[] tmp = new Node[length];
        Node current = head;
        for( int i =0; i < length;i++){
            tmp[i] = current;
            current = current.getNext();
        }
        for(int i = length - 1; i > 0;i--){
            tmp[i].setNext(tmp[i-1]);
        }
        tmp[0].setNext(null);
        head = tmp[length - 1];
        tail = tmp[0];
    }


    public void reverseInplace(){
        if( length == 0){
            return;
        }
        Node prev = null;
        Node next= head;
        while(next!= null){
            Node tmp = next.getNext();
            next.setNext(prev);
            prev = next;
            next = tmp;
        }
        head = prev;
    }
    public boolean containsCircle(){
        Set<Node> cache = new HashSet<>();
        Node current = head;
        while( current != null){
            if( cache.contains(current)){
                return true;
            } else{
                cache.add(current);
            }
            current = current.getNext();
        }
        return false;
    }
    // ¼ì²â»·
    public static boolean checkCircle(Node list) {
        if (list == null) return false;

        Node fast = list.getNext();
        Node slow = list;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (slow == fast) return true;
        }

        return false;
    }

    public Node<T> deleteNth(int lastnth){
        Node[] cache = new Node[length];
        Node curr = head;
        int index = 0;
        while( curr != null){
            cache[index++] = curr;
            curr = curr.getNext();
        }
        if(lastnth == cache.length - 1){
            head = cache[cache.length - lastnth];
        }else{
            cache[cache.length -2 - lastnth].setNext(cache[cache.length -1 - lastnth].getNext());
        }

        return  cache[cache.length -1 - lastnth];
    }

    public Node getMiddle(){
        Node slow = head.getNext();
        Node fast = head.getNext().getNext();
        while( fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }





    @Override
    public String toString() {
        String tmp = "";
        if(length == 0){
            return tmp;
        }
        Node curr = head;
        while(curr != null){
            tmp+=curr.getData();
            curr = curr.getNext();
        }
        return tmp;
    }
}
