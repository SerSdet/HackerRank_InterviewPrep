package s08_dynamicProgramming;

public class MaxArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,-1,-3,-4,-5};
        System.out.println(maxSubsetSum(arr));
    }

    /**
     * Method returns maximum subset of non-adjacent elements in array.
     * @param arr sample array
     * @return maximum possible sum of non-adjacent elements in array 'arr'
     *
     * First, array checked that it had at least two element, if not return that only element (if it is bigger than zero)
     *          or zero.
     *
     * Then, create an array with same size with a sample array, this array will store the maximum sum of adjacent
     * elements after same index element taken into consideration.
     *
     * After that, assign first and second elements of the result array.
     *             - First element will be the first element of the array.
     *             - Second one must be bigger one of second element of array or first element of result
     *
     * After that start a loop from the third element of the array,
     *       - Each element of result array can be calculated as that index of 'arr' and two before result element,
     *         But since some elements of 'arr' can be negative, this number must be compared with index of 'arr'
     *         and bigger one of previous result element and element before that element.
     *
     * When the loop finished, last result array element checked whether it is negative, if so return 0 otherwise that
     * element will be returned as result.
     */

    static int maxSubsetSum(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return Math.max(arr[0], 0);
        int[] res = new int[arr.length];
        res[0] = Math.max(0,arr[0]);
        res[1] = Math.max(res[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            res[i] = Math.max((res[i - 2] + arr[i]), res[i - 1]);
        }
        return Math.max(res[res.length - 1], 0);

    }
}
