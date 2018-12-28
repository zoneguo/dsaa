package com.zone.dsaa.tree;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree(int[] arr) {
        root = buildBinaryTree(arr, 0);
    }

    public BinaryNode buildBinaryTree(int[] arr, int index) {
        if (index < arr.length) {
            if (arr[index] != 0) {
                BinaryNode node = new BinaryNode(arr[index]);
                node.left = buildBinaryTree(arr, index*2 + 1);
                node.right = buildBinaryTree(arr, index*2 + 2);
                return node;
            }
        }

        return null;
    }

    public BinaryNode getRoot() {
        return root;
    }

    /**
     * 先序遍历
     * @param root
     */
    public void preOrderTraverse(BinaryNode root) {
        if (root != null) {
            System.out.print(root.element + ", ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void midOrderTraverse(BinaryNode root) {
        if (root != null) {
            midOrderTraverse(root.left);
            System.out.print(root.element + ", ");
            midOrderTraverse(root.right);
        }
    }

    /**
     * 后续遍历
     * @param root
     */
    public void postOrderTraverse(BinaryNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.element + ", ");
        }
    }

    /**
     * 深度优先遍历，等同于先序遍历
     * @param root
     */
    public void depthOrderTraverse(BinaryNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            System.out.print(node.element + ", ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public void levelOrderTraverse(BinaryNode root) {
        if (root == null) {
            return;
        }

        LinkedList<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            System.out.print(node.element + ", ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }




}
