package com.jabaddon.back2basics.datastructures.tree;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class DepthFirstInOrderTraversal<T> extends TraversalAlgorithm<T> {
    public DepthFirstInOrderTraversal(Node<T> root) {
        super(root);
    }

    @Override
    public void traverse() {
        traverse(this.root);
    }

    private void traverse(Node<T> node) {
        if (node != null) {
            traverse(node.left);
            visit(node);
            traverse(node.right);
        }
    }
}
