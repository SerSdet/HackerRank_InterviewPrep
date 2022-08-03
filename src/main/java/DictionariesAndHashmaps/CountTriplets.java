package DictionariesAndHashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountTriplets {
    public static void main(String[] args) {
            Long[] sample = new Long[]{1L, 2L, 2L, 4L,};
            long r = 2L;
            List<Long> arr = new ArrayList<>(Arrays.asList(sample));
            System.out.println(countTriplets(arr,r));
    }

    /**
     * Method return number of triplets in array 'arr' that are in geometric progression (n, n*r, n*2r) for
     * a given common ratio 'r'
     *    "question don't mentioned but arrays assumed sorted, bc algorithm work only if arrays sorted,
     *    if this happened, algorithm can be fixed by sorting the array before all the steps."
     *
     * @param arr array that will be searched for triplets
     * @param r common ratio
     * @return number of triplets
     *
     * Brute force approach not valid bc of time constraints
     *
     * First, we create 2 HashMap,
     *       - rightMap for storing elements larger than middle element that we are searching
     *       - leftMap for storing elements smaller than middle elements that we are searching
     * Then, we add all array elements to rightMap,and we store unique elements and repetition,
     * Then, start searching for each array arr elements for triplets,
     *       - first assign element as midElement
     *       - then assign 1st and 3rd element as 0,
     *       - remove mid-element from right array
     *       - Check if there is any triplet with this mid element
     *          - search smaller element :
     *               - mid-element must be divisible to 'r' and mid-element/r exists in left array,
     *                  if that elements exists in left array, assign c1 as repetition of this element.
     *               - look for right element (mid-element*r) in right map,
     *                  if that elements exists in left array, assign c3 as repetition of this element.
     *               - increase counter as c1*c3 bc, there can be that number of triplet can be formed from
     *                 these elements
     *               - add mid-element to left Map for next search
     * Finally, return the counter.
     */

    private static long countTriplets(List<Long> arr, long r) {
        Long count = 0L;
        HashMap<Long, Long> rightMap = new HashMap<>();
        HashMap<Long, Long> leftMap = new HashMap<>();


        for (Long item : arr) {
            rightMap.put(item, rightMap.getOrDefault(item, 0L) + 1);
        }

        for (int i = 0; i < arr.size(); i++) {
            Long midTerm = arr.get(i);
            Long c1 = 0L;
            Long c3 = 0L;
            rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);
            if (midTerm % r == 0 && leftMap.containsKey(midTerm / r)) {
                c1 = leftMap.get(midTerm / r);
            }
            if (rightMap.containsKey(midTerm * r)) {
                c3 = rightMap.get(midTerm * r);
            }
            count += (c1 * c3);
            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
        }
        return count;
    }
}
