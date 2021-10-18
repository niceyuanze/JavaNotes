package datastructure.tree;

import datastructure.linearList.linkedList.HomeMadeSinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    private TreeNode<T> root;

    public List<TreeNode<T>> preOrderTraverse() {
        return preOrderTraverse(new ArrayList<>(), root);
    }

    private List<TreeNode<T>> preOrderTraverse(ArrayList<TreeNode<T>> result, TreeNode<T> root) {
        if (root != null) {
            result.add(root);
        }

        result.addAll(preOrderTraverse(result, root.getLeft()));
        result.addAll(preOrderTraverse(result, root.getRight()));

        return result;
    }

    public List<TreeNode> inOrderTraverse() {
        return new ArrayList<>();
    }

    public List<TreeNode> postOrderTraverse() {
        return new ArrayList<>();
    }

    public HomeMadeSinglyLinkedList<TreeNode<T>> levelOrderTraverse() {
        HomeMadeSinglyLinkedList<TreeNode<T>> result = new HomeMadeSinglyLinkedList<>();
        HomeMadeSinglyLinkedList<TreeNode<T>> cache = new HomeMadeSinglyLinkedList<>();
        cache.put(root);
        levelOrderTraverse(cache, new HomeMadeSinglyLinkedList<>());
        return result;
    }

    public void levelOrderTraverse(HomeMadeSinglyLinkedList<TreeNode<T>> cache, HomeMadeSinglyLinkedList<TreeNode<T>> result) {
        TreeNode<T> current = cache.deleteNth(0).getData();
        if (current.getLeft() == null && current.getRight() == null) {
            return;
        }
        if (current.getLeft() != null) {
            result.put(current.getLeft());
        }
        if (current.getRight() != null) {
            result.put(current.getRight());
        }
        levelOrderTraverse(cache, result);
    }


}
