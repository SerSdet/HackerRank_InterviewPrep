package s02_search;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MaxSubArraySum {
    public static void main(String[] args) {
        Long[]arr = new Long[]{1L,5L,9L};
        int modulus = 5;
        System.out.println(maximumSum(Arrays.asList(arr), modulus));
    }

    /**
     * Function return maximum sub-array sum that modulo 'm' for an array 'a'
     * @param a array with length n
     * @param m long variable that used for modulo
     * @return the sub-array sum as long
     *
     * For each element of 'a' we calculate (for loop), let say we are at the element a[j];
     *      - First, calculate sum of elements from index 0 to 'j'th element by adding previous sum and
     *              calculate its modulus with m.
     *      - Then, if this new sum is bigger than previous sum, we update maxSum.
     *      - Declare x as a number that smallest higher number than calculated previously calculated sum
     *      - If we have that kind of number (means x is not null)
     *          - subtract that number from the sum, this results some negative number so we add 'm' to this
     *          number to make it positive and calculate its modulus (math rule : a%m = (a+m)%m)
     *          - if this number is bigger than maxSum, we update maxSum
     *          - if we find the max sum can be calculated in modulus 'm', which is 'm-1' return that value
     *          - add sum to the prefixes TreeSet and restart to loop
     * Return maxSum after the loop completed.
     */
    public static long maximumSum(List<Long> a, long m) {
        TreeSet<Long>prefixes = new TreeSet<>();
        long sum = 0; //sum for a[0] to a[i]
        long maxSum = 0; // max sum that calculated from the start of the loop
        long theSum = m-1; // the maxSum which is 'm-1' (max sum for modulus 10 is 10-1 = 9)

        for (long d : a){
            sum = (sum + d % m) % m;
            maxSum = Math.max(maxSum, sum);
            //The higher() is a method of TreeSet class.
            // This method returns the smallest element in the set which is greater than the element
            // in the argument, else it will return null if the element is not present.
            Long x = prefixes.higher(sum);
            if ( x != null){
                long tmp = (sum - x + m) % m;
                maxSum = Math.max(maxSum, tmp);
            }
            if(maxSum == theSum) return theSum;
            prefixes.add(sum);
        }
        return maxSum;
    }
}
