package com.zone.dsaa.tree;

public class BinaryNode<Type> {
    public Type element;
    public BinaryNode<Type> left;
    public BinaryNode<Type> right;

    public BinaryNode(Type element) {
        this(element, null, null);
    }

    public BinaryNode(Type element, BinaryNode<Type> left, BinaryNode<Type> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
