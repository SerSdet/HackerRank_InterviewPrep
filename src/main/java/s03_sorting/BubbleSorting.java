package s03_sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSorting {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,2,1};
        countSwaps(Arrays.asList(arr));
    }

    /**
     * This method called bubble sorting.
     * Start from first element of the array and move it toward end of the array,
     * Do this loop for the entire array, so we swap the biggest number to the end of the array.
     * @param a array that will be sorted
     */

    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int swapCount = 0;
        for (int i = 0; i < a.size(); i++){
            for (int j = 0; j < a.size()-1; j++){
                if(a.get(j)> a.get(j+1)){
                    Integer tmp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, tmp);
                    swapCount++;
                }
            }
        }
        System.out.println("Array is sorted in "+ swapCount + " swaps.");
        System.out.println("First Element: "+ a.get(0) );
        System.out.println("Last Element: "+ a.get(a.size()-1));
    }

}
