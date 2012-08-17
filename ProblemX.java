

public class ProblemX {

    public static int[] createArray(int from, int to) {
        int[] array = new int[(to - from) + 1];
        int init = from;
        for (int i = from; i <= to; ++i) {
            array[i] = from++;
        }
        return array;
    }

    public static int[] initArray() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = 0;
        }
        return array;
    }

    public static int[] findDuplicateValue(int[] array) {
        int[] duplicateValues = initArray();
        for (int i = 0; i < array.length; ++i) {
            duplicateValues[array[i]] += 1;
        }
        return duplicateValues;
    }

    public static void main(String[] args) {
        int[] array = createArray(0, 99);
        System.out.println("array.length = [" + array.length + "]");

        array[25] = 2;
        int[] dv = findDuplicateValue(array);
        for (int i = 0; i < dv.length; ++i) {
            System.out.printf("dv[%d] = %d\n", i, dv[i]);    
        }
    }
}