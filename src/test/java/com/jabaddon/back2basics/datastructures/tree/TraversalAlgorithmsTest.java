package com.jabaddon.back2basics.datastructures.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Testing the 3 kinds of Depth First Traversals:
 * 1. InOrder
 * 2. PreOrder
 * 3. PostOrder
 *
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class TraversalAlgorithmsTest {
    private Node root;

    @Before
    public void createTree() {
        Node<String> nf = new Node<String>("F");
        Node<String> nb = new Node<String>("B");
        Node<String> ng = new Node<String>("G");
        Node<String> na = new Node<String>("A");
        Node<String> nd = new Node<String>("D");
        Node<String> nc = new Node<String>("C");
        Node<String> ne = new Node<String>("E");
        Node<String> ni = new Node<String>("I");
        Node<String> nh = new Node<String>("H");

        buildTree(nf, nb, ng);
        buildTree(nb, na, nd);
        buildTree(nd, nc, ne);
        buildTree(ng, null, ni);
        buildTree(ni, nh, null);

        root = nf;
    }

    private void buildTree(Node root, Node left, Node right) {
        root.left = left;
        root.right = right;
    }

    @Test
    public void testDepthFirst_PreOrder_Traversal() {
        TraversalAlgorithm<String> dfpot = new DepthFirstPreOrderTraversal<String>(root);
        dfpot.traverse();

        StringBuilder strb = new StringBuilder();
        for (String str : dfpot.getTraversalList()) {
            strb.append(str);
        }

        assertThat(strb.toString(), is("FBADCEGIH"));
    }

    @Test
    public void testDepthFirst_InOrder_Traversal() {
        TraversalAlgorithm<String> dfpot = new DepthFirstInOrderTraversal<String>(root);
        dfpot.traverse();

        StringBuilder strb = new StringBuilder();
        for (String str : dfpot.getTraversalList()) {
            strb.append(str);
        }

        assertThat(strb.toString(), is("ABCDEFGHI"));
    }

    @Test
    public void testDepthFirst_PostOrder_Traversal() {
        TraversalAlgorithm<String> dfpot = new DepthFirstPostOrderTraversal<String>(root);
        dfpot.traverse();

        StringBuilder strb = new StringBuilder();
        for (String str : dfpot.getTraversalList()) {
            strb.append(str);
        }

        assertThat(strb.toString(), is("ACEDBHIGF"));
    }

    @Test
    public void testBreadthFirst_Traversal() {
        TraversalAlgorithm<String> dfpot = new BreadthFirst<String>(root);
        dfpot.traverse();

        StringBuilder strb = new StringBuilder();
        for (String str : dfpot.getTraversalList()) {
            strb.append(str);
        }

        assertThat(strb.toString(), is("FBGADICEH"));
    }
}
