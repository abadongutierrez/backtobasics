package com.jabaddon.back2basics.datastructures.tree;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class SortedBinaryTree<T> {
    private Node<T> root;

    public SortedBinaryTree() {
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (this.root == null) {
            this.root = newNode;
        }
        else {

        }
    }

    public Node<T> getRoot() {
        return this.root;
    }
}
