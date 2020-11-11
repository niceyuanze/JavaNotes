package datastructure.linearList.queue;

public class CircularQueueBasedOnArray<T> {

    private T[] data;

    private int head;

    private int tail;

    private int max = 5;

    public CircularQueueBasedOnArray() {
        data  = (T[]) new Object[max];
    }


    public boolean enQueue(T item){
//    这个地方必须要用+1的写法，并且如果没有size属性帮助的话，不用+1写法没法判断是否是空的队列
        if( (tail + 1) % max == head){
            return false;
        }
        data[tail] = item;
        tail = (++tail) % max;
        return true;
    }
    public T dequeue(){
        if(head == tail){
            return null;
        }
        T tmp = data[head];
        head = ( head + 1) % max;
        return tmp;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for(int i = head; i != tail;i = ++i % max){
            s.append(data[i]);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        CircularQueueBasedOnArray<Integer> circularQueueBasedOnArray = new CircularQueueBasedOnArray<>();
        System.out.println(circularQueueBasedOnArray);
        circularQueueBasedOnArray.enQueue(1);
        System.out.println(circularQueueBasedOnArray);
        circularQueueBasedOnArray.enQueue(2);
        System.out.println(circularQueueBasedOnArray);
        circularQueueBasedOnArray.enQueue(3);
        System.out.println(circularQueueBasedOnArray);
        circularQueueBasedOnArray.enQueue(4);
        System.out.println(circularQueueBasedOnArray);
        circularQueueBasedOnArray.enQueue(5);
        System.out.println(circularQueueBasedOnArray);
        System.out.println(circularQueueBasedOnArray.dequeue());
        System.out.println(circularQueueBasedOnArray);
        circularQueueBasedOnArray.enQueue(5);
        System.out.println(circularQueueBasedOnArray);
        circularQueueBasedOnArray.enQueue(6);
        System.out.println(circularQueueBasedOnArray);
    }
}
