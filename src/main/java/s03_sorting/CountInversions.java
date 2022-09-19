package s03_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversions {
    public static void main(String[] args) {
        Integer[]arr1 = new Integer[]{1, 1, 1, 2, 2};
        Integer[]arr2 = new Integer[]{2, 1, 3, 1, 2};
        Integer[] ar = new Integer[] {1,4,6,8,2,5,7,9,10};

//        int n = 20;
//        int nn = 1;
//        int mid = n >> nn;
//        System.out.println(mid);
        List<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(arr2));
        System.out.println(countInversions(Arrays.asList(arr2)));
        System.out.println(countInversions(Arrays.asList(ar)));
    }

    /**
     * This is a recursive method that calculate number of inversions int the array
     * @param arr array that will be sorted
     * @return number of swaps between adjacent elements
     *
     * First, check that if an array contain only one element, if so return 0 (Base Case)
     * Then, split the array into two part, one is left and other is right
     * Then, if these two half required inversions first required inversion is summation of those, (Recursive call step)
     * Then, start to merge these arrays and while doing it increase number of swaps if swap required,
     *       First, initialize left and right index pointers and define range as the size mid to end of the array,
     *       Then, if left index smaller than mid AND
     *                  right index >= range (means all right array used) OR left element at left index smaller than right element at right index
     *               - then use left element at left index and increase left index one, and required inversion is index of right array,
     *                (bc, if we used right array element before it means it requires an inversion. think 2 element)
     *             else if right index smaller than range than add element in right array and increase right index one
     *       When the loop ends return the number of conversions.
     */

    public static long countInversions(List<Integer> arr) {
        int n = arr.size();
        //Base Case
        if (n <= 1){
            return 0;
        }
        //Recursive Case
        int mid = n/2;
        List<Integer>left = new ArrayList<>(arr.subList(0,mid));
        List<Integer>right = new ArrayList<>(arr.subList(mid,n));

        long inversions = countInversions(left) + countInversions(right);

        int range = n - mid;
        int iLeft = 0;
        int iRight = 0;

        for (int i = 0; i < n; i++){
            if((iLeft < mid) && (iRight >=range || left.get(iLeft) <= right.get(iRight))){
                arr.set(i,left.get(iLeft));
                iLeft++;
                inversions += iRight;
            }else if (iRight < range){
                arr.set(i, right.get(iRight));
                iRight++;
            }
        }
        return inversions;
    }


}
