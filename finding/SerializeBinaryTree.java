public class SerializeBinaryTree<T extends Comparable<T>> {

    private Node root;
    private java.util.Queue<Node<T>> bsfList = new java.util.LinkedList<Node<T>>();
    private Node nonode = new Node(1);
    private int count = 0;

    private class Node<T> {
        public T value;
        public Node left, right;

        public Node(T value) {
            this.value = value;
        }
    }

    public SerializeBinaryTree() {
        root = new Node(2);
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(1);
        Node n4 = new Node(6);
        Node n5 = new Node(7);
        Node n6 = new Node(9);
        Node n7 = new Node(8);
        Node n8 = new Node(4);

        root.left = n1;
        root.right = n2;

        n1.left = n8;
        n1.right = n7;

        n2.left = null;
        n2.right = n3;

        n3.left = n4;
        n3.right = n6;

        n4.right = null;
        n4.left = n5;
    }

    public void print() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.println(node.value + " ");
        printTree(node.right);
    }

    public void printUsingBSF() {
        count = 0;
        bsfList.add(root);
        printTreeBSF();
    }

    private void printTreeBSF() {
        if (bsfList.size() == 0) {
            return;
        }
        else {
            int size = bsfList.size();
            boolean allNull = true;
            for (int i = 0; i < size; i++) {
                Node n = bsfList.remove();
                if (n != null) {
                    allNull = false;
                    bsfList.add(n.left);
                    bsfList.add(n.right);
                }
                else {
                    bsfList.add(null);
                    bsfList.add(null);
                }
                System.out.print((n != null ? n.value : "null") + ",");
            }
            System.out.println();
            if (!allNull) {
                printTreeBSF();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Init...");
        SerializeBinaryTree<Integer> sbt = new SerializeBinaryTree<Integer>();
        sbt.print();
        System.out.println("-------");
        sbt.printUsingBSF();
    }
}