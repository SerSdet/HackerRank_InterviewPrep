package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxMin {
    public static void main(String[] args) {
        Integer[]sample = new Integer[]{100 ,200, 300,350,400,401,402};
        List<Integer> arr = new ArrayList<>(Arrays.asList(sample));
        int k = 3;
        System.out.println(maxMin(k,arr));
    }

    /**
     * Return the minimum difference between minimum and maximum numbers in sub-array chosen elements from array
     * @param k number of elements in sub array
     * @param arr sample array
     * @return minimum difference between min and max values
     *
     * First, array sorted by using sort method from collections framework
     * Then, create minMax value and initiate as the largest element in array (it is the biggest possible difference)
     * After that, start from the beginning calculate possible differences between min and max values of the arrays.
     *              each arrays 0 index will be i and last index will be (i + k - 1).
     *            Then, update the maxMin value with this value
     * After the loop finished, return the maxMin value.
     */
    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int maxMin = arr.get(arr.size()-1);

        for (int i = 0; i <= arr.size() - k; i++){
            int tmp = arr.get(i + k -1) - arr.get(i);
            maxMin = Math.min(maxMin, tmp);
        }
        return maxMin;
    }
}
