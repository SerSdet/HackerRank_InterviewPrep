package s07_greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        System.out.println(minimumAbsoluteDifference(Arrays.asList(arr)));
    }

    /**
     * Method returns minimum absolute difference between any two elements in the array
     * @param arr array that minimum absolute difference will be searched
     * @return    minimum absolute difference between any two elements in the array
     *
     * First, array will be sorted, so elements that are closest to each other must be side by side,
     *  (Sorting method explained below)
     *Then, loop through the element and difference checked.
     *All differences compared with found one and minimum value returned to main method.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        if(arr.size() == 2){
            return Math.abs(arr.get(0)-arr.get(1));
        }

        int tmp = Integer.MAX_VALUE;
        List<Integer> sortedArray = sortList(arr);
        for (int i =  0; i < sortedArray.size() - 1; i++){
            int calc = Math.abs(sortedArray.get(i) - sortedArray.get(i + 1));
            tmp = Math.min(calc, tmp);
        }
        return tmp;
    }

    /**
     * This method sort the array by using Merge sort algorithm recursively
     * @param arr array that will be sorted
     * @return sorted 'arr' array
     *
     * - If array has only one element, then return that element
     * - Create new array to store sorted elements
     * - Create variables to store;
     *      length of array 'n'
     *      middle index of an array 'mid'
     *
     * - Split the array into two from the middle as lef and right,
     * - Then create variables for;
     *      range of right array 'range'
     *      index for left and right arrays
     * - After that start a for loop to up to 'n', which is total number of elements in array
     *    - If left index smaller than mid - index AND current left element smaller than right element or
     *         right index bigger than range (means all right elements are used)
     *       - Add left current element c
     *      Else if right index is smaler than range
     *       - Add right current element to sorted array and increase right index by one
     *
     */
    private static List<Integer> sortList(List<Integer> arr) {
        if( arr.size() <= 1) {
            return arr;
        }
        List<Integer> sorted = new ArrayList<>();
        int n = arr.size();
        int mid = arr.size() / 2;

        List<Integer> left = sortList(arr.subList(0, mid));
        List<Integer> right = sortList(arr.subList(mid, arr.size()));

        int range =  n - mid;
        int iLeft = 0;
        int iRight = 0;

        for (int i = 0; i < n ; i++){
            if((iLeft < mid) && (iRight >= range || left.get(iLeft) <= right.get(iRight))){
                sorted.add(left.get(iLeft++));
            }else if (iRight < range){
                sorted.add(right.get(iRight++));
            }
        }
        return sorted;
    }
}
