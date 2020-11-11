package datastructure.linearList.linkedList;

public class LRUBasedOnArray<T> {
    private T[] data;

    private int max = 0;

    private int head = 0;

    private int size = 0;

    public LRUBasedOnArray() {
        this.data = (T[]) new Object[3];
        this.max = 3;
    }

    public void add(T item){
        int cache = find(item);
        if(cache < 0){
            if(size == max){
                for(int i = 0; i < max - 1; i++){
                    data[i] = data[i+1];
                }
                data[size - 1 ] = item;
                return;
            }else{
                data[size++] = item;
                return ;
            }
        }else{
            T tmp = data[cache];
            for(int i = cache; i < size -1 ;i++){
                data[i] = data[i+1];
            }
            data[size -1] = tmp;
            return;

        }
    }
    public int find(T item){
        int resultIndex = -1;
        for(int i = 0; i < size - 1;i++){
            if (data[i].equals(item)){
                return i;
            }
        }
        return resultIndex;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for(int i = size - 1; i > -1; i--){
            s.append(data[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        LRUBasedOnArray<Integer> lruBasedOnArray = new LRUBasedOnArray<>();
        System.out.println(lruBasedOnArray);
        lruBasedOnArray.add(1);
        System.out.println(lruBasedOnArray);
        lruBasedOnArray.add(2);
        System.out.println(lruBasedOnArray);
        lruBasedOnArray.add(3);
        System.out.println(lruBasedOnArray);
        lruBasedOnArray.add(4);
        System.out.println(lruBasedOnArray);
        lruBasedOnArray.add(2);
        System.out.println(lruBasedOnArray);
    }
}
