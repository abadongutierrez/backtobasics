package com.jabaddon.back2basics.datastructures.tree;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class DepthFirstPreOrderTraversal<T> extends TraversalAlgorithm<T> {
    public DepthFirstPreOrderTraversal(Node<T> root) {
        super(root);
    }

    @Override
    public void traverse() {
        traverse(this.root);
    }

    private void traverse(Node<T> node) {
        if (node != null) {
            visit(node);
            traverse(node.left);
            traverse(node.right);
        }
    }
}
