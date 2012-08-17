/*
 * Implementation based on Wikipedia article: http://en.wikipedia.org/wiki/Quicksort
 */
import java.util.*;

public class IntegerListBubbleSort {

    public static List<Integer> bubbleSort(List<Integer> ints) {
        if (ints.size() <= 1) {
            return ints;
        }
        else if (ints.size() == 2) {
            
        }

        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < ints.size(); ++i) {
                if (ints.get(i).compareTo((ints.get(i+1) !)))
            }

        }
        while(swapped);
    }

    public static void main(String[] args) {
        List<Integer> aux = Arrays.asList(4, 5, 7, 8, 1, 9, 2, 6, 3, 10, 20, 19, 17, 15, 14, 11, 12, 16, 13, 18);
        // Arrays.asList returns a List implementation that doesnt support remove operation
        List<Integer> ints = new ArrayList<Integer>();
        for (Integer x : aux) ints.add(x);

        System.out.println("Before: " + ints);
        List sortedList = bubbleSort(ints);
        System.out.println("After : " + sortedList);
    }
}