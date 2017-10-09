package algorithm;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeNonRecursive<K extends Comparable<K>, V> {

    public static void main(String[] args) {
        BinarySearchTreeNonRecursive<String, String> binarySearchTreeNonRecursive =
                new BinarySearchTreeNonRecursive<>();
        binarySearchTreeNonRecursive.insert("S","S");
        binarySearchTreeNonRecursive.insert("E","E");
        binarySearchTreeNonRecursive.insert("A","A");
        binarySearchTreeNonRecursive.insert("R","R");
        binarySearchTreeNonRecursive.insert("C","C");
        binarySearchTreeNonRecursive.insert("H","H");
        binarySearchTreeNonRecursive.insert("E","E");
        binarySearchTreeNonRecursive.insert("X","X");
        System.out.println("middle order ");
        binarySearchTreeNonRecursive.middleOrder();
        System.out.println("min");
        System.out.println(binarySearchTreeNonRecursive.min());
        System.out.println("max");
        System.out.println(binarySearchTreeNonRecursive.max());
        System.out.println("floor");
        System.out.println("D" + binarySearchTreeNonRecursive.floor("D"));
        System.out.println("B" + binarySearchTreeNonRecursive.floor("B"));
        System.out.println("I" + binarySearchTreeNonRecursive.floor("I"));
        System.out.println("F" + binarySearchTreeNonRecursive.floor("F"));
        System.out.println("T" + binarySearchTreeNonRecursive.floor("T"));
        System.out.println("Z" + binarySearchTreeNonRecursive.floor("Z"));
        System.out.println("select");
        System.out.println("1" + binarySearchTreeNonRecursive.select(1));
        System.out.println("2" + binarySearchTreeNonRecursive.select(2));
        System.out.println("3" + binarySearchTreeNonRecursive.select(3));
        System.out.println("4" + binarySearchTreeNonRecursive.select(4));
        System.out.println("5" + binarySearchTreeNonRecursive.select(5));
        System.out.println("6" + binarySearchTreeNonRecursive.select(6));
        System.out.println("7" + binarySearchTreeNonRecursive.select(7));
        System.out.println("rank");
        System.out.println("A" + binarySearchTreeNonRecursive.rank("A"));
        System.out.println("C" + binarySearchTreeNonRecursive.rank("C"));
        System.out.println("E" + binarySearchTreeNonRecursive.rank("E"));
        System.out.println("H" + binarySearchTreeNonRecursive.rank("H"));
        System.out.println("R" + binarySearchTreeNonRecursive.rank("R"));
        System.out.println("S" + binarySearchTreeNonRecursive.rank("S"));
        System.out.println("X" + binarySearchTreeNonRecursive.rank("X"));
        System.out.println("DELETE MIN");
        binarySearchTreeNonRecursive.deleteMin();
        binarySearchTreeNonRecursive.middleOrder();






    }



    private Node root;

    public Node insert(K key, V value){
        root = insert( root, key, value);
        return root;
    }
    private Node insert(Node node, K key, V value){

        if( node == null){
            node = new Node( key, value, 1);
            return node;
        }
        LinkedList<Node> path = new LinkedList<>();
        while(node != null){
            if( node.key.compareTo(key) < 0){
                if( node.right == null){
                    path.add(node);
                    node.right = new Node(key, value, 1);
                    increase(path);
                    return path.getFirst();
                }
                path.add(node);
                node = node.right;
            }else if ( node.key.compareTo(key) > 0){
                if(node.left == null){
                    path.add(node);
                    node.left = new Node(key, value, 1);
                    increase(path);
                    return path.getFirst();
                }
                path.add(node);
                node = node.left;
            }else {
                path.add(node);
                node.value = value;
                return path.getFirst();
            }
        }
        return null;
    }
    private void increase(List<Node> list){
        list.forEach( e -> e.N++);
    }

    public void middleOrder(){
        middleOrder(root);
    }
    private void middleOrder(Node root){
        if( root.left != null){
            middleOrder( root.left);
        }
        System.out.println(root);
        if( root.right != null){
            middleOrder( root.right);
        }
    }

    public Node min(){
        return min(root);
    }
    private Node min(Node node){
        if(node == null){
            return null;
        }

        while(true){
            if(node.left == null){
                return node;
            }else{
                node = node.left;
            }
        }
    }

    public Node max(){
        return max(root);
    }
    private Node max(Node node){
        if( node == null){
            return null;
        }
        while(true){
            if(node.right == null){
                return node;
            }
            node = node.right;
        }

    }


    public Node floor(K key){
        return floor( root, key);
    }

    private Node floor(Node node, K key){

        if( node == null || key == null){
            throw new NullPointerException("The parameter of this method can't be NULL");
        }

        Node tmp = null;
        while (true){
            int cmp = node.key.compareTo(key);
            if( cmp > 0){

                if(node.left == null){
                    if(tmp != null){
                        return tmp;
                    }
                    return null;
                }
                node = node.left;
            }
            if( cmp == 0){
                //二叉树我们还是走
                return node;
            }
            if( cmp < 0){
                //右子树没有了啊，那肯定当前节点小等于目标节点是最大的
                if(node.right == null){
                    return node;
                }
                //先把这个节点记下来，往下看看有没有更大一点点的
                tmp = node;
                //二叉树我们走
                node = node.right;
            }
        }

    }


    public Node select(int ranking){
        return select( root, ranking);

    }

    private Node select(Node node, int n){
        if(node == null){
            return null;
        }
        while(true){
            int size = size(node.left);
            if(size + 1 > n){
                node = node.left;
//                n = size - n;
            }else if(size + 1 < n){
                node = node.right;
                n = n - size - 1;
            }else{
                return node;
            }
        }

    }

    public int rank(K key){
        return rank( root, key);
    }

    private int rank(Node node, K key){
        if( node == null){
            return -1;
        }
        int result = 0;
        int cmp = 0;
        while(true){
            cmp = key.compareTo(node.key);
            if( cmp < 0){
                node = node.left;
            }else if ( cmp > 0){
                result += size(node.left) + 1;
                node = node.right;
            }else {
                return (result + size(node.left) + 1);
            }
        }

    }

    private int size(Node node){
        if(node == null){
            return 0;
        }else{
            return node.N;
        }
    }

//    private Node delete(Node node, K key){
//        if( node == null){
//            return null;
//        }
//        Node tmp = node;
//        int cmp = key.compareTo(node.key);
//        if( cmp < 0){
//            tmp = node;
//            node = node.left;
//        }else if( cmp > 0){
//            tmp = node;
//            node = node.right;
//        }else{
//            if(node.left != null && node.right != null){
//                Node next = min(node.right);
//
//            }
//            if(node.left == null && node.right == null){
//                if(tmp.left == node){
//                    tmp.left = null;
//                }else if(tmp.right == node){
//                    tmp.right = null;
//                }
//            }
//        }
//    }


    public Node deleteMin(){
        root = deleteMin(root);
        return root;
    }

    private Node deleteMin(Node node){
        if( node == null){
            return null;
        }
        LinkedList<Node> path = new LinkedList<>();
        while(true){
            if(node.left == null){
                if(path.getLast() != null){
                    path.getLast().left = node.right;
                    path.forEach( e -> e.N--);
                }else{
                    path.add( node.right);
                }
                return path.getFirst();
            }else{
                path.add(node);
                node = node.left;
            }
        }
    }


//    private Node findNext(Node node){
//        if(node == null){
//            return null;
//        }
//
//        while(true)
//    }




    private class Node{

        public K key;

        public V value;

        public Node left;

        public Node right;

        public int N;


        public Node() {
        }

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
//                    ", left=" + left +
//                    ", right=" + right +
                    ", N=" + N +
                    '}';
        }
    }
}
