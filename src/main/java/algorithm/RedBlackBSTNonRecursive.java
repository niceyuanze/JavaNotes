package algorithm;

import java.util.LinkedList;

public class RedBlackBSTNonRecursive<K extends Comparable<K>, V> {

    public static void main(String[] args) {
        RedBlackBSTNonRecursive<String, String> redBlackBSTNonRecursive =
                new RedBlackBSTNonRecursive<>();
        redBlackBSTNonRecursive.put("S", "S");
        redBlackBSTNonRecursive.put("E", "E");
        redBlackBSTNonRecursive.put("A", "A");
        redBlackBSTNonRecursive.put("R", "R");
        redBlackBSTNonRecursive.put("C", "C");
        redBlackBSTNonRecursive.put("H", "H");
        redBlackBSTNonRecursive.put("X", "X");
        redBlackBSTNonRecursive.put("M", "M");
        redBlackBSTNonRecursive.put("P", "P");
        redBlackBSTNonRecursive.put("L", "L");
        redBlackBSTNonRecursive.middleOrder();



    }

    public void middleOrder(){
        middleOrder(root);
    }
    private void middleOrder(Node node){
        LinkedList<Node> path = new LinkedList<>();
        while(node != null || path.size() != 0){

            //这是别人写的，下面是我写的，我觉得我写的思路不是很清晰，学习依稀ｓ
            while(node != null){
                path.add( node);
                node = node.left;
            }
            node = path.pollLast();
            System.out.println(node);
            node = node.right;

//            if(node == null){
//                if(path.size() != 0){
//                    node = path.pollLast();
//                    System.out.println(node);
//                    node = node.right;
//                    continue;
//                }else{
//                    break;
//                }
//            }
//
//            if( node.left != null){
//                path.add(node);
//                node = node.left;
//            }else{
//                System.out.println(node);
//                node = node.right;
//            }

        }
    }
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private boolean isRed(Node node){
        if( node == null){
            return BLACK;
        }
        return node.color;
    }
    private Node rotateLeft(Node h){

        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public int size(){
        return size(root);
    }
    private int size(Node node){
        if(node == null){
            return 0;
        }else{
            return node.N;
        }
    }
    public Node put(K key, V value){
        return root = put(root, key, value);
    }
    private Node put(Node h, K key, V value){
        if( h == null){
            return new Node( key, value, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        LinkedList<Node> path = new LinkedList<>();
        while(true){
            path.add(h);
            cmp = key.compareTo(h.key);
            if( cmp < 0){
                if(h.left == null){
                    path.getLast().left = new Node( key, value, 1, RED);
                    break;
                }
                h = h.left;
            }else if( cmp > 0){
                if(h.right == null){
                    path.getLast().right = new Node( key, value, 1, RED);
                    break;
                }
                h = h.right;
            }else{
                h.value = value;
                return path.getLast();
            }
        }
        while(path.size() != 0){
            h = path.pollLast();
            if( isRed( h.right) && !isRed( h.left)){
                if(path.size() != 0){
                    if(path.getLast().left == h){
                        path.getLast().left = rotateLeft(h);
                    }else{
                        path.getLast().right = rotateLeft(h);
                    }
                }else{
                    h = rotateLeft(h);
                }

            }
           if( isRed( h.left) && isRed( h.left.left)){
               if(path.size() != 0){
                   if(path.getLast().left == h){
                       h = rotateRight(h);
                       flipColors(h);
                       path.getLast().left = h;
                   }else{
                       h = rotateRight(h);
                       flipColors(h);
                       path.getLast().right = h;
                   }
               }else{
                   h = rotateRight(h);
                   flipColors(h);
               }


            }
            if( isRed( h.left) && isRed( h.right)){
                flipColors(h);
            }
        }
        return h;


    }
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }



    private Node moveRedLeft(Node h){
        flipColors(h);
        if( isRed(h.right.left)){
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node balance(Node h){
        if(isRed(h.right)){
             h = rotateLeft(h);
        }
        if(isRed(h.right) && isRed(h.left)){
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }





    public class Node{

        public K key;
        public V value;
        public int N;
        public boolean color;
        public Node left;
        public Node right;

        public Node(K key, V value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", N=" + N +
                    ", color=" + color +
                    '}';
        }
    }
}
