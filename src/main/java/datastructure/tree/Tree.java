package datastructure.tree;

import datastructure.linearList.linkedList.HomeMadeSinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Tree<T,V> {

    private TreeNode<T,V> root;
//
//    public List<TreeNode<T>> preOrderTraverse() {
//        return preOrderTraverse(new ArrayList<>(), root);
//    }
//
//    private List<TreeNode<T>> preOrderTraverse(ArrayList<TreeNode<T>> result, TreeNode<T> root) {
//        if (root != null) {
//            result.add(root);
//        }
//
//        result.addAll(preOrderTraverse(result, root.getLeft()));
//        result.addAll(preOrderTraverse(result, root.getRight()));
//
//        return result;
//    }
//
//    public List<TreeNode> inOrderTraverse() {
//        return new ArrayList<>();
//    }
//
//    public List<TreeNode> postOrderTraverse() {
//        return new ArrayList<>();
//    }
//
    public HomeMadeSinglyLinkedList<TreeNode> levelOrderTraverse() {
        HomeMadeSinglyLinkedList<TreeNode> result = new HomeMadeSinglyLinkedList<>();
        HomeMadeSinglyLinkedList<TreeNode> cache = new HomeMadeSinglyLinkedList<>();
        cache.put(root);
        levelOrderTraverse(cache, new HomeMadeSinglyLinkedList<TreeNode>());
        return result;
    }

    public void levelOrderTraverse(HomeMadeSinglyLinkedList<TreeNode> cache, HomeMadeSinglyLinkedList<TreeNode> result) {
        if(root == null){
            return;
        }
        TreeNode<T,V> current = cache.deleteNth(0).getData();
        if (current.getLeft() == null && current.getRight() == null) {
            result.put(current);
            return;
        }
        if (current.getLeft() != null) {
            cache.put(current.getLeft());
        }
        if (current.getRight() != null) {
            cache.put(current.getRight());
        }
        levelOrderTraverse(cache, result);
    }


}
