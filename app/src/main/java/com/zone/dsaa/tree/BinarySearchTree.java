package com.zone.dsaa.tree;

import android.util.Log;

import com.zone.dsaa.debug.Debug;

/**
 *
 * @param <Type>
 * TODO
 * 1. 注意这里面的泛型参数上界和下界
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> {
    private BinaryNode<Type> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Type x) {
        // TODO
        return false;
    }

    public Type findMin() {
        if (isEmpty()) {
            throw new UnsupportedOperationException();
        }
        // TODO
        return null;
    }

    public Type findMax() {
        if (isEmpty()) {
            throw new UnsupportedOperationException();
        }
        // TODO
        return null;
    }

    public void insert(Type x) {

    }

    public void remove(Type x) {

    }

    private boolean contains(Type x, BinaryNode<Type> root) {
        if (root == null || x == null) {
            return false;
        }

        int compareResult = x.compareTo(root.element);
        if ( compareResult < 0) {
            return contains(x, root.left);
        } else if (compareResult > 0) {
            return contains(x, root.right);
        } else {
            return true;
        }
    }

    private BinaryNode<Type> findMin(BinaryNode<Type> root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    private BinaryNode<Type> findMinRecursive(BinaryNode<Type> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root;
        } else {
            return findMinRecursive(root.left);
        }
    }

    private BinaryNode<Type> findMax(BinaryNode<Type> root) {
        if (root == null) {
            return null;
        }

        while(root.right != null) {
            root = root.right;
        }

        return root;
    }

    /**
     * TODO
     * 非常规的更改参数的值，而是通过返回值来更新
     * @param x
     * @param root
     * @return
     */
    private BinaryNode<Type> insert(Type x, BinaryNode<Type> root) {
        if (root == null) {
            return new BinaryNode<Type>(x);
        }

        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            root.left = insert(x, root.left);
        } else if (compareResult > 0) {
            root.right = insert(x, root.right);
        } else {
            // TODO duplicate do nothing
        }

        return root;
    }

    private BinaryNode<Type> remove(Type x, BinaryNode<Type> root) {
        if (root == null) {
            // not found, do nothing
            return null;
        }

        int compareResult = x.compareTo(root.element);

        if (compareResult < 0) {
            root.left = remove(x, root.left);
        } else if (compareResult > 0) {
            root.right = remove(x, root.right);
        } else {
            if (root.left != null && root.right != null) {
                root.element = findMin(root.right).element;
                remove(root.element, root.right);
            } else {
                root = (root.left != null) ? root.left : root.right;
            }
        }

        return root;
    }

    public void printTree() {
        if (isEmpty()) {
            Log.d(Debug.TAG, "Empty tree");
        }
    }

    private void printTree(BinaryNode<Type> t) {
        if (t != null) {
            printTree(t.left);
            Log.d(Debug.TAG, "element = " + t.element);
            printTree(t.right);
        }
    }

    private int height(BinaryNode<Type> t) {
        if (t == null) {
            return -1;
        }

        return 1 + Math.max(height(t.left), height(t.right));
    }
}
