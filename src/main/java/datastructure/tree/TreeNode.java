package datastructure.tree;

public class TreeNode<T,V> {

    private T key;

    private V value;

    private TreeNode<T,V> left;

    private TreeNode<T,V> right;

    public TreeNode(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public TreeNode<T,V> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T,V> left) {
        this.left = left;
    }

    public TreeNode<T,V> getRight() {
        return right;
    }

    public void setRight(TreeNode<T,V> right) {
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
