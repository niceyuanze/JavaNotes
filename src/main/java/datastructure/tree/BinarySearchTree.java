package datastructure.tree;

/**
 * 常见问题:
 * 1.卡特兰数,n个节点有多少种树二叉树的可能
 * 2.什么叫做卫星数据
 * 3.时间复杂度与高度成正比，高度的计算逻辑，复习一下等比数列求和公式
 * <p>
 * 我们利用对象的某个字段作为键值（key）来构建二叉查找树。我们把对象中的其他字段叫作卫星数据。
 * 卫星数据:指的是一条纪录中除了关键字key以外的其他数据
 * <p>
 * 时间复杂度其实都跟树的高度成正比
 * <p>
 * 等比数列求和公式，
 * <p>
 * <p>
 * 与hash表进行对比:
 * 1.散列表无序，二叉搜索树有序
 * 2.散列冲突耗时，平衡二叉查找树稳定O(logn)
 * 3.hash函数可能也比较耗时
 * 4.hash函数更加复杂
 * 5.装填因子不能大，但是这样会有内存浪费
 * <p>
 * 极端  变成链表O(n)-O(logn)变成完全二叉树
 * <p>
 * 求树的高度
 * leetcode 104 题
 * 二叉查找树删除操作 leetcode 450
 * <p>
 * <p>
 * 坐下，这些都是二叉树的基本操作！ https://mp.weixin.qq.com/s/ONKJyusGCIE2ctwT9uLv9g
 */
public class BinarySearchTree<T extends Comparable<T>, V> {

    private TreeNode<T, V> root;

    public void insert(T key, V value) {
        root = innerInsert(root, new TreeNode<>(key, value));

    }

    private TreeNode innerInsert(TreeNode<T, V> root, TreeNode<T, V> value) {
        if (root == null) {
            return value;
        } else if (value.getKey().compareTo(root.getKey()) > 0) {
            root.setRight(innerInsert(root.getRight(), value));
        } else {
            root.setLeft(innerInsert(root.getLeft(), value));
        }
        return root;
    }


    public void delete(T key) {
        root = innerDelete(root, key);
    }

    private TreeNode innerDelete(TreeNode<T, V> root, T key) {
        if (root == null) {
            return null;
        }
        if (root.getKey().equals(key)) {
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            }
            if (root.getLeft() == null ^ root.getRight() == null) {
                if (root.getLeft() != null) {
                    return root.getLeft();
                } else {
                    return root.getRight();
                }
            }
            TreeNode tmp = root.getRight();
            root = root.getLeft();
            root = innerInsert(root, tmp);
        } else if (key.compareTo(root.getKey()) < 0) {
            root.setLeft(innerDelete(root.getLeft(), key));
        } else {
            root.setRight(innerDelete(root.getRight(), key));
        }
        return root;
    }

    public TreeNode get(T key) {
        return innerGet(root, key);
    }

    private TreeNode innerGet(TreeNode<T, V> root, T key) {
        if (root == null) {
            return null;
        }
        if (root.getKey().compareTo(key) == 0) {
            return root;
        } else if (root.getKey().compareTo(key) > 0) {
            return innerGet(root.getLeft(), key);
        } else {
            return innerGet(root.getRight(), key);
        }
    }

    public int getDepth() {
        return innerGetLength(root);
    }


    /**
     * 深度优先求树的高度
     * @param root
     * @return
     */
    private int innerGetLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() != null && root.getRight() != null) {
            return Math.max(innerGetLength(root.getLeft()), innerGetLength(root.getRight())) + 1;
        } else if (root.getLeft() != null) {
            return innerGetLength(root.getLeft()) + 1;
        } else {
            return innerGetLength(root.getRight()) + 1;
        }

    }


    public TreeNode<T, V> getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(4, "four");
//        binarySearchTree.insert(3, "three");

        binarySearchTree.insert(5, "five");
        binarySearchTree.insert(6, "six");

        System.out.println(binarySearchTree.getRoot());
        System.out.println("深度" + binarySearchTree.getDepth());
        System.out.println(binarySearchTree.get(6));
        binarySearchTree.delete(3);
        System.out.println(binarySearchTree.getRoot());


    }


}
