package com.jabaddon.back2basics.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public abstract class TraversalAlgorithm<T> {
    protected final Node<T> root;
    protected final List<T> list = new ArrayList<T>();

    public TraversalAlgorithm(Node<T> root) {
        this.root = root;
    }

    public List<T> getTraversalList() {
        return this.list;
    }

    public void visit(Node<T> node) {
        this.list.add(node.data);
    }

    public abstract void traverse();
}
