package com.zone.dsaa.tree.avl;

public class AvlNode<Type> {
    public int height;
    public AvlNode<Type> left;
    public AvlNode<Type> right;
    public Type element;

    public AvlNode(Type element, AvlNode<Type> left, AvlNode<Type> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    public AvlNode(Type element) {
        this(element, null, null);
    }
}
