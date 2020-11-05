package datastructure.linearList.linkedList;

public class HomeMadeSinglySortLinkedList<T extends Comparable<T>> {

    private Node<T> head;

    private Node<T> tail;

    private int length = 0;



    public boolean insert(T input){
        if(head == null){
            head = new Node<>(input);
        }else {
            Node curr = head;
            Node prev = null;
            while(curr != null && input.compareTo((T)curr.getData()) > 0){
                prev = curr;
                curr = curr.getNext();
            }
            Node node =  new Node(input);
            node.setNext(curr);
            if(prev != null){
                prev.setNext(node);
            }else{
                head = node;
            }
        }

        return true;
    }
    public void merge(HomeMadeSinglySortLinkedList otherSortLinkedList){
        Node<T> other = otherSortLinkedList.getHead();
        Node<T> curr = head;
        Node<T> currPrev = null;
        while (other != null){
            if(curr.getData().compareTo( other.getData()) >= 0){
                Node<T> otherNext = other.getNext();
                other.setNext(curr);
                curr = other;
                if(currPrev == null){
                    head = other;
                }
                other = otherNext;
            } else{
                Node<T> currNext = curr.getNext();
                Node<T> otherNext = other.getNext();
                while( currNext != null && currNext.getData().compareTo(other.getData()) <= 0){
                    curr = currNext;
                    currNext = currNext.getNext();
                }
                curr.setNext(other);
                other.setNext(currNext);
                currPrev = other;
                curr = other;
                other = otherNext;
            }

        }
    }

    @Override
    public String toString() {
        String result = "";
        Node curr = head;
        while( curr != null ){
            result+= curr.getData();
            curr = curr.getNext();
        }
        return result;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
