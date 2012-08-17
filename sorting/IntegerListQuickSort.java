/*
 * Implementation based on Wikipedia article: http://en.wikipedia.org/wiki/Quicksort
 */
import java.util.*;

public class IntegerListQuickSort {

    public static List<Integer> concatenate(List<Integer> less, Integer pivot, List<Integer> greater) {
        less.add(pivot);
        for (Integer x: greater) {
            less.add(x);
        }
        return less;
    }

    public static List<Integer> quickSort(List<Integer> ints) {
        // an array of zero or one elements is already sorted
        if (ints.size() <= 1) {
            return ints;
        }
        // select and remove a pivot value 'pivot' from 'array'
        Integer pivot = ints.get(ints.size() / 2);
        ints.remove(pivot); // <= List implementation has to support remove
        List<Integer> less = new ArrayList<Integer>();
        List<Integer> greater = new ArrayList<Integer>();
        for (Integer x: ints) {
            if (x.compareTo(pivot) >= 1) {
                greater.add(x);
            }
            else {
                less.add(x);
            }
        }
        return concatenate(quickSort(less), pivot, quickSort(greater));
    }

    public static void main(String[] args) {
        List<Integer> aux = Arrays.asList(4, 5, 7, 8, 1, 9, 2, 6, 3, 10, 20, 19, 17, 15, 14, 11, 12, 16, 13, 18);
        // Arrays.asList returns a List implementation that doesnt support remove operation
        List<Integer> ints = new ArrayList<Integer>();
        for (Integer x : aux) ints.add(x);

        System.out.println("Before: " + ints);
        List sortedList = quickSort(ints);
        System.out.println("After : " + sortedList);
    }
}