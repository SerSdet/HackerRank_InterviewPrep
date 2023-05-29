package s08_dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candies {
    public static void main(String[] args) {
        Integer[]arr = new Integer[]{2,4,2,6,1,7,8,9,2,1};

        List<Integer> grades = new ArrayList<>(Arrays.asList(arr));
        System.out.println(candies(arr.length, grades));
    }

    /**
     * Determine minimum number of candy required to buy to give student. Distribution of candy must satisfy
     * these two condition :
     *  - First, each student must take at least one candy
     *  - Second, if student have high rating compare to next student must take high number of candy.
     *
     * @param n number of students
     * @param arr ranking value of students
     * @return minimum number of candy
     *
     * First, create an array to store each number of candy each student must take
     * Then, assign all values of the array as 1, so each student must have at least one candy
     * After that, start a loop from the left (index 0) and check,
     *        if student has high rating increase its candy one
     * After this loop, start another loop, which start from the end to beginning and check,
     *        if student has high rating AND candy number is smaller, then increase the candy one
     * Finally, sum all the elements in candy array and return the sum
     *
     */

    public static long candies(int n, List<Integer> arr) {
        int[] candies = new int[n];
        long candySum = 0;
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i + 1) > arr.get(i)) {
                candies[i + 1] = candies[i] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (arr.get(i - 1) > arr.get(i) && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            candySum += candies[i];
        }
        return candySum;
    }

}
