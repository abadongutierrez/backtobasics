
class Bag<T> implements Iterable<T>, java.util.Iterator<T> {
    private java.util.List<T> elements = new java.util.ArrayList<T>();
    private int iterationIndex = -1;

    public void add(T item) {
        elements.add(item);
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public int size() {
        return elements.size();
    }

    // {{{ Iterable methods
    public java.util.Iterator<T> iterator() {
        System.out.println("Hey, llamarion iterator!");
        iterationIndex = -1;
        return this;
    }
    // }}}

    // Iterator methods
    public boolean hasNext() {
        if ((iterationIndex + 1) >= this.size()) {
            return false;
        }
        return true;
    }

    public T next() {
        return elements.get(++iterationIndex);
    }

    public void remove() {
    }
    // }}}
}

// -------------------------------------------------------------------------------------------------

public class BagStats {
    public static void main(String[] args) {
        Bag<Double> bag = new Bag<Double>();

        bag.add(100.0);
        bag.add(99.0);
        bag.add(101.0);
        bag.add(120.0);
        bag.add(98.0);
        bag.add(107.0);
        bag.add(109.0);
        bag.add(81.0);
        bag.add(101.0);
        bag.add(90.0);

        int N = bag.size();
        double sum = 0.0;

        for (double x: bag) {
            sum += x;
        }
        double mean = sum/N;

        sum = 0.0;

        for (double x: bag) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum/(N - 1));

        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }
}