package com.jabaddon.back2basics.datastructures.tree;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class Node<T> {
    public T data;
    public Node<T> left, right;

    public Node(T data) {
        this.data = data;
    }

    public String toString() {
        return "{" + String.valueOf(data) + "}";
    }
}
