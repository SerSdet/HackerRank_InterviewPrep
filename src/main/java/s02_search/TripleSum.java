package s02_search;

import java.util.Arrays;
import java.util.HashSet;

public class TripleSum {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{5, 7, 9};
        int[] c = new int[]{7, 9, 11, 13};
//        int a1 = -1;
//        a1 = -1-a1-1;
//        System.out.println(a1);
//        System.out.println(a1+1);
        System.out.println(getValidIndex(a, 5 ));
//        System.out.println(getValidIndex(a, 1 ));
//        System.out.println(getValidIndex(a, 8 ));
//        System.out.println(getValidIndex(a, 10 ));

       System.out.println(triplets(a,b,c));
    }

    /**
     * Return the number of triplets in tree array, that p from a, q from b and r from c. Where p <=q and q >=r
     * @param a array (p)
     * @param b array (q)
     * @param c array (r)
     * @return number of different triplets
     *
     * First, remove duplicates from the arrays with different method (by using hash map)
     * Then, sort the arrays (it is required for the binary search)
     * Then, get validIndex (explained below) for the array for the A and C arrays
     *        and add +1 to change index to element count
     * Then, number of triplets for this element can be calculated by multiplying these two element,
     * Then, add this multiplication to general sum
     * Finally, return the final count of triplets
     */
    static long triplets(int[] a, int[] b, int[] c) {
        long triplets = 0;
        int[] indistinctA = removeDuplicates(a);
        int[] indistinctB = removeDuplicates(b);
        int[] indistinctC = removeDuplicates(c);
        Arrays.sort(indistinctA);
        Arrays.sort(indistinctB);
        Arrays.sort(indistinctC);
        for(int q : indistinctB){
            long elementsInArrayA = getValidIndex(indistinctA,q) + 1;
            long elementsInArrayC = getValidIndex(indistinctC,q) + 1;
            triplets += (elementsInArrayA * elementsInArrayC);
        }
        return triplets;
    }

    /**
     * Remove the duplicates in the array. To remove duplicates first we create a hash set and putt all the values in it
     * so new hash set only has unique values. then return this hash set as an array, that duplicates removed.
     * @param a integer array
     * @return an array that duplicates are removed and sorted
     *
     */
    private static int[] removeDuplicates(int[] a){
        HashSet<Integer>tmp = new HashSet<>();
        for (int q : a){
            tmp.add(q);
        }
        int [] result =  new int[tmp.size()];
        int i = 0;
        for(int q : tmp){
            result[i] = q;
            i++;
        }
        return result;
    }

    /**
     * Return the valid index for array that all the elements are smaller or equal to key element. Algorithm is
     * based on binary search
     * @param distinctArray array, that sorted and consists of unique elements
     * @param key element that are searched
     * @return the array index that is the biggest element that satisfy smaller and equal to key element
     *
     * First, assign the 'low' as smallest array index, which is 0.
     * Then, assign the 'high' as biggest index, which is length -1.
     * Then, valid index as -1 which returns if the key is smaller than first element of array
     * Start the loop and continue while low is smaller than or equal to high
     *       - define mid-index as low plus half of the small and high index
     *       - if array element in mid-index smaller or equal to key (means key in second part),
     *          - validIndex become mid,
     *          - low become mid +1
     *        -else, (means key in first part ) high become mid -1;
     */
    private static int getValidIndex (int[]distinctArray, int key) {
        int low = 0;
        int high = distinctArray.length - 1;
        int validIndex = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(distinctArray[mid] <= key) {
                validIndex = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            }
        return validIndex;
        }
}

