package s02_search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 5, 3, 4, 2};
        System.out.println(pairs(2, Arrays.asList(arr)));

    }

    /**
     * Program finds number of pairs that have a difference 'k' from each other
     * @param k difference must be found between elements
     * @param arr number array that we are searching pairs
     * @return number of pairs can be found in array
     *
     * Algorithm based on the HashSet, which contain only unique values.
     *
     * First, initiate count and an empty hashset,
     * Then, loop through the array and search :
     *      - has hashset contain element, that has a difference between this element (positive or negative). If found
     *      increase counter
     *      - add this element to the hash set
     * Finally, return the counter
     */
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int count = 0;
        Set<Integer> exists = new HashSet<>();
        for (int i = 0; i < arr.size(); i++){
            if(exists.contains(arr.get(i) - k)) count ++;
            if(exists.contains(arr.get(i) + k)) count ++;
            exists.add(arr.get(i));
        }
        return count;
    }
}
