package datastructure.linearList.queue;

public class QueueBasedOnArray<T> {

    private T[] data;

    private int max = 0;

    private int head;

    private int tail;

    public QueueBasedOnArray() {
        this.max = 5;
        this.data = (T[]) new Object[this.max];
    }

    private boolean enqueue(T item){
        if(tail == max){
            if(head != 0){
                System.out.println("”≈ªØ");
                for(int i = head; i < tail;i++){
                    data[i-head] = data[i];
                }
                tail = tail - head  ;
                head = 0;
            }else{
                return false;
            }
        }
        data[tail++] = item;
        return true;
    }
    private T dequeue(){
        if(head == tail){
            return null;
        }
        return data[head++];
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for(int i = head; i < tail;i++){
            s.append(data[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        QueueBasedOnArray<Integer> queueBasedOnArray = new QueueBasedOnArray<>();
        System.out.println(queueBasedOnArray);
        queueBasedOnArray.enqueue(1);
        System.out.println(queueBasedOnArray);
        queueBasedOnArray.enqueue(2);
        System.out.println(queueBasedOnArray);
        queueBasedOnArray.enqueue(3);
        System.out.println(queueBasedOnArray);
        queueBasedOnArray.enqueue(4);
        System.out.println(queueBasedOnArray);
        queueBasedOnArray.enqueue(5);
        System.out.println(queueBasedOnArray);
        queueBasedOnArray.enqueue(6);
        System.out.println(queueBasedOnArray);
        System.out.println(queueBasedOnArray.dequeue());
        System.out.println(queueBasedOnArray);
        queueBasedOnArray.enqueue(6);
        System.out.println(queueBasedOnArray);
    }
}
