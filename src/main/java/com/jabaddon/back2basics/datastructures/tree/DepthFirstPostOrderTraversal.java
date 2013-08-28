package com.jabaddon.back2basics.datastructures.tree;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class DepthFirstPostOrderTraversal<T> extends TraversalAlgorithm<T> {
    public DepthFirstPostOrderTraversal(Node<T> root) {
        super(root);
    }

    @Override
    public void traverse() {
        traverse(this.root);
    }

    private void traverse(Node<T> node) {
        if (node != null) {
            traverse(node.left);
            traverse(node.right);
            visit(node);
        }
    }
}
