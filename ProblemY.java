

public class ProblemY {
    public static int[] findSubArrayWithLargetsSum(int[] originalArray) {
        java.util.List<int[]> rangos = new java.util.ArrayList<int[]>();
        int[] currRange = null;
        for (int i = 0; i < originalArray.length; ++i) {
            if (originalArray[i] >= 0) {
                if (currRange == null) {
                    currRange = new int[]{-1, -1, originalArray[i]};
                    currRange[0] = i;
                }
                else {
                    currRange[2] += originalArray[i];
                }
            }
            else if (originalArray[i] < 0) {
                if (currRange != null) {
                    if (currRange[0] != (i - 1)) {
                        currRange[1] = (i - 1);
                        rangos.add(currRange);
                        currRange = null;
                    }
                    else {
                        currRange = null;   
                    }
                }
            }
        }

        if (currRange != null) {
            currRange[1] = originalArray.length - 1;
            rangos.add(currRange);
            currRange = null;
        }

        int[] adds = new int[rangos.size()];
        for (int i = 0; i < rangos.size(); ++i) {
            adds[i] = rangos.get(i)[2];
        }
        java.util.Arrays.sort(adds);

        int[] maxRange = null;
        for (int[] rango: rangos) {
            if (rango[2] == adds[rangos.size() - 1]) {
                maxRange = rango;
                break;
            }
        }

        System.out.printf("maxRange[%d, %d, %d]", maxRange[0], maxRange[1], maxRange[2]);
        return java.util.Arrays.copyOfRange(originalArray, maxRange[0], maxRange[1] + 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 2, 3, 5, 10, -14, -2, 1, 4, -6, 1, -4, 5, 8, 1};

        int[] subarray = findSubArrayWithLargetsSum(array);
        System.out.println("size = " + subarray.length);
        System.out.print("[");
        for (int i = 0; i < subarray.length; ++i) {
            System.out.print(subarray[i] + " ");
        }
        System.out.print("]\n");
    }
}