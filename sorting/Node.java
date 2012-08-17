public class Node<T extends Comparable> {
    public T item;
    public Node<T> next;

    public void print() {
        System.out.print("item[" + item + "]");
    }
}