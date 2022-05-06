package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulation {
    public static void main(String[] args) {
        Integer[]q1 = new Integer[]{1,5,3};
        Integer[]q2 = new Integer[]{4,8,7};
        Integer[]q3 = new Integer[]{6,9,1};
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(q1));
        queries.add(Arrays.asList(q2));
        queries.add(Arrays.asList(q3));
        int arrSize = 10;
        System.out.println(arrayManipulation(arrSize,queries));
    }

    /**
     *
     * @param n size of array we will fill
     * @param queries 3 element array that first element shows starting point, second one ending point (inclusively)
     *                and the third one represent value to be added
     * @return maximum number in th array
     *
     * First, we create a result array, that we fill according to queries,
     * Then, we go through each query;
     *      we put added value start point,
     *      we put -added value to after the end point (end+1) if end point in the boundary of the array
     * Then, we go through the result array and add previous element to next element.
     *       While we are doing this aggregate we check max value in each step
     * Finally, we return max value.
     *
     * Note for the logic : when we are adding some number to series it will start with starting point
     * and after the ending point it won't be added, so we marked as minus value.
     * (Consider the last addition step of the algorithm)
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long[] result = new long[n];
        int length = queries.size();
        long max = Long.MIN_VALUE;

        for (int i = 0; i < length; i++){
            int start = queries.get(i).get(0)-1;
            int end = queries.get(i).get(1)-1;
            int add = queries.get(i).get(2);
            result[start]+=add;
            if (end + 1 < n){
                result[end + 1] -= add;
            }
        }
        for (int i = 1; i < n; i++){
            result[i]+=result[i-1];
            max = Math.max(max, result[i]);
        }

        return max;
    }
}
