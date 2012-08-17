/*
 * Implementation based on Wikipedia article: http://en.wikipedia.org/wiki/Merge_sort
 */
import java.util.*;

public class IntegerListMergeSort {

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<Integer>();
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                if (left.get(0).compareTo(right.get(0)) <= 0) {
                    Integer item = left.get(0);
                    left.remove(item);
                    result.add(item);
                }
                else {
                    Integer item = right.get(0);
                    right.remove(item);
                    result.add(item);
                }
            }
            else if (left.size() > 0) {
                Integer item = left.get(0);
                left.remove(item);
                result.add(item);                
            }
            else if (right.size() > 0) {
                Integer item = right.get(0);
                right.remove(item);
                result.add(item);
            }
        }
        return result;
    }

    public static List<Integer> mergeSort(List<Integer> ints) {
        // if list size is 1, consider it sorted and return it
        if (ints.size() <= 1) {
            return ints;
        }
        // else list size is > 1, so split the list into two sublists
        int splitSize = ints.size() / 2;
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();    
        for (int i = 0; i < splitSize; ++i) {
            left.add(ints.get(i));
        }
        for (int i = 0; i < (ints.size() - splitSize); ++i) {
            right.add(ints.get(i + splitSize));
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(4, 5, 7, 8, 1, 9, 2, 6, 3, 10, 20, 19, 17, 15, 14, 11, 12, 16, 13, 18);

        System.out.println("Before: " + ints);
        List sortedList = mergeSort(ints);
        System.out.println("After: " + sortedList);
    }
}