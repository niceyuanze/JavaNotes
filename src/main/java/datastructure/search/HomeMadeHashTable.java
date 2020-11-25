package datastructure.search;


public class HomeMadeHashTable<K,V> {

    private Node<K,V>[] data;

    private int size = 0;

    private int capacity = 0;
    public HomeMadeHashTable(){

        this.data = new Node[4];
        for(int i = 0 ; i < data.length; i++){
            data[i] = new Node(null,null);
        }
        this.capacity = 4;
    }
    public boolean put(K key, V value){
        int hashCode = key.hashCode();
        int index = hashCode % (capacity - 1);
        Node<K,V> current = data[index];
        while(current.getNext() != null){
            current = current.getNext();
            if( current.getKey().equals(key)){
                current.setValue(value);
                return true;
            }
        }
        Node<K,V> node = new Node<>(key,value);
        node.setKey(key);
        node.setValue(value);
        node.setHashCode(hashCode);
        current.setNext(node);
        node.setPrev(current);
        return true;
    }

    private class Node<K,V>{
        private Node<K,V> next;

        private Node<K,V> prev;

        private int hashCode;

        private K key;

        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public Node<K, V> getPrev() {
            return prev;
        }

        public void setPrev(Node<K, V> prev) {
            this.prev = prev;
        }

        public int getHashCode() {
            return hashCode;
        }

        public void setHashCode(int hashCode) {
            this.hashCode = hashCode;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }



    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for(Node<K,V> node : data){
            while(node.getNext() != null){
                node = node.getNext();
                stringBuffer.append(node.getKey());
                stringBuffer.append(":");
                stringBuffer.append(node.getValue());
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        HomeMadeHashTable<String,String> homeMadeHashTable = new HomeMadeHashTable<>();
        homeMadeHashTable.put("1","1");
        homeMadeHashTable.put("2","2");
        homeMadeHashTable.put("3","3");
        homeMadeHashTable.put("4","4");
        homeMadeHashTable.put("5","5");
        homeMadeHashTable.put("6","6");
        homeMadeHashTable.put("7","7");
        homeMadeHashTable.put("8","8");
        System.out.println(homeMadeHashTable);
        homeMadeHashTable.put("8","9");
        System.out.println(homeMadeHashTable);
        homeMadeHashTable.put("9","10");
        System.out.println(homeMadeHashTable);

    }
}
