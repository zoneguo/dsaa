package com.zone.dsaa.tree;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private static int[] arr = {1, 3, 6, 8, 12, 7, 29, 47, 35, 0, 99, 0, 0, 68, 0};

    private static BinaryTree tree;

    @BeforeClass
    public static void setup() {
        tree = new BinaryTree(arr);
    }

    @Test
    public void buildBinaryTree() {

    }

    @Test
    public void preOrderTraverse() {
        System.out.println("preOrderTraverse");
        tree.preOrderTraverse(tree.getRoot());
    }

    @Test
    public void midOrderTraverse() {
        System.out.println("midOrderTraverse");
        tree.midOrderTraverse(tree.getRoot());
    }

    @Test
    public void postOrderTraverse() {
        System.out.println("postOrderTraverse");
        tree.postOrderTraverse(tree.getRoot());
    }

    @Test
    public void depthOrderTraverse() {
        System.out.println("depthOrderTraverse");
        tree.depthOrderTraverse(tree.getRoot());
    }

    @Test
    public void levelOrderTraverse() {
        System.out.println("levelOrderTraverse");
        tree.levelOrderTraverse(tree.getRoot());
    }
}