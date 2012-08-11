class Queue<T> implements Iterable<T> {
    private java.util.List<T> elements = new java.util.ArrayList<T>();

    public void enqueue(T item) {
        elements.add(item);
    }

    public T dequeue() {
        if (this.size() > 0) {
            T removedItem = elements.get(0);
            elements.remove(removedItem);
            return removedItem;
        }
        return null;
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public int size() {
        return elements.size();
    }

    public java.util.Iterator<T> iterator() {
        return elements.iterator();
    }
}

public class FifoQueue  {
    public static void main(String[] args) {
        int[] items = {5, 4, 3, 2, 1};

        Queue<Integer> queue = new Queue<Integer>();
        for (int x : items) {
            queue.enqueue(x);
        }

        for (int x : queue) {
            System.out.println("item: " + x);
        }
    }
}