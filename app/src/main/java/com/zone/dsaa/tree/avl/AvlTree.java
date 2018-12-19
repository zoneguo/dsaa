package com.zone.dsaa.tree.avl;

public class AvlTree<Type extends Comparable<? super Type>> {
    private AvlNode<Type> root;

    public AvlTree() {
        root = null;
    }

    public void insert(Type x) {
        root = insert(x, root);
    }

    private AvlNode<Type> insert(Type x, AvlNode<Type> t) {
        if (t == null) {
            return new AvlNode<>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(root.right) == 2) {
                if (x.compareTo(t.left.element) < 0) {
                    // case1
                    t = rotateWithLeftChild(t);
                } else {
                    // case2
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2) {
                if (x.compareTo(t.right.element) > 0) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else {
            // Duplicate do nothing
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    // 写算法的时候必须要把case1的图给画出来
    private AvlNode<Type> rotateWithLeftChild(AvlNode<Type> k2) {
        AvlNode<Type> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    // 写算法的时候必须把case4的图给画出来
    private AvlNode<Type> rotateWithRightChild(AvlNode<Type> k1) {
        AvlNode<Type> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;

        return k2;
    }

    // case 2 左-右
    private AvlNode<Type> doubleWithLeftChild(AvlNode<Type> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    // case3 右-左
    private AvlNode<Type> doubleWithRightChild(AvlNode<Type> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private int height(AvlNode<Type> t) {
        return (t == null) ? -1 : t.height;
    }

}
