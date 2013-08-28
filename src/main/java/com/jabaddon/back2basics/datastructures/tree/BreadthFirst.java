package com.jabaddon.back2basics.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class BreadthFirst<T> extends TraversalAlgorithm<T> {
    public BreadthFirst(Node<T> root) {
        super(root);
    }

    @Override
    public void traverse() {
        traverse(this.root);
    }

    private void traverse(Node<T> node) {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(node);
        while (!queue.isEmpty()) {
            // peek() retrieves but not remove
            // poll() retrieves and remove
            Node<T> n = queue.poll();
            visit(n);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }
}
