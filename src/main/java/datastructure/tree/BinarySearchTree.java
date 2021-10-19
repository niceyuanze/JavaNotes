package datastructure.tree;

/**
 * ��������:
 * 1.��������,n���ڵ��ж��������������Ŀ���
 * 2.ʲô������������
 * 3.ʱ�临�Ӷ���߶ȳ����ȣ��߶ȵļ����߼�����ϰһ�µȱ�������͹�ʽ
 * <p>
 * �������ö����ĳ���ֶ���Ϊ��ֵ��key����������������������ǰѶ����е������ֶν����������ݡ�
 * ��������:ָ����һ����¼�г��˹ؼ���key�������������
 * <p>
 * ʱ�临�Ӷ���ʵ�������ĸ߶ȳ�����
 * <p>
 * �ȱ�������͹�ʽ��
 * <p>
 * <p>
 * ��hash����жԱ�:
 * 1.ɢ�б����򣬶�������������
 * 2.ɢ�г�ͻ��ʱ��ƽ�����������ȶ�O(logn)
 * 3.hash��������Ҳ�ȽϺ�ʱ
 * 4.hash�������Ӹ���
 * 5.װ�����Ӳ��ܴ󣬵������������ڴ��˷�
 * <p>
 * ����  �������O(n)-O(logn)�����ȫ������
 * <p>
 * �����ĸ߶�
 * leetcode 104 ��
 * ���������ɾ������ leetcode 450
 * <p>
 * <p>
 * ���£���Щ���Ƕ������Ļ��������� https://mp.weixin.qq.com/s/ONKJyusGCIE2ctwT9uLv9g
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
     * ������������ĸ߶�
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
        System.out.println("���" + binarySearchTree.getDepth());
        System.out.println(binarySearchTree.get(6));
        binarySearchTree.delete(3);
        System.out.println(binarySearchTree.getRoot());


    }


}
