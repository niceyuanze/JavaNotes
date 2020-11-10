package datastructure.linearList.stack;

import datastructure.ArrayUtil;


public class StackBasedOnArray<T> {

    private int capacity;

    private T[] data;

    private int size = 0;

    private int head = 0;

    public StackBasedOnArray(int capacity) {
        this.capacity = capacity;
        this.data = (T[])new Object[capacity];
    }
    public boolean push(T item){
        if( this.size == capacity){
            this.data = ArrayUtil.grow(this.data);
            System.out.println("À©ÈÝ");
        }
        this.data[this.head] = item;
        this.head++;
        this.size++;
        return true;
    }
    public T pop(){
        if( size == 0){
            return null;
        }
        size--;
        return data[--head];
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0 ; i < size; i++){
            stringBuffer.append(data[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        StackBasedOnArray<Integer> stackBasedOnArray = new StackBasedOnArray<>(3);
        stackBasedOnArray.push(1);
        stackBasedOnArray.push(2);
        stackBasedOnArray.push(3);
        stackBasedOnArray.push(4);

        System.out.println(stackBasedOnArray);
        stackBasedOnArray.pop();
        System.out.println(stackBasedOnArray);
        stackBasedOnArray.pop();
        System.out.println(stackBasedOnArray);
        stackBasedOnArray.pop();
        System.out.println(stackBasedOnArray);
        stackBasedOnArray.pop();
        System.out.println(stackBasedOnArray);
        stackBasedOnArray.pop();
        System.out.println(stackBasedOnArray);
    }
}
