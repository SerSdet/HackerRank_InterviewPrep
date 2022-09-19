package s01_arrays;

public class MinimumSwaps {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,3,2,4,5,6};
        System.out.println(minimumSwaps(arr));
    }

    /**
     * @param arr
     * @return number of swaps required to sort the array in ascending order.
     *
     * In this approach we start with index 0 and make sure that index is equal to 1 (first element of the series)
     * Determine swap required or not for array element (i+1 == a[i]),
     *        if swap required (i+1 != a[i])
     *          - first, determine which index should that element must go (i-1)
     *          - then, determine what value stored at that index,
     *          - then, store the value at i for swapping
     *          - then, swap the values a[i] and a[a[i]-1],
     *          - finally, increase swap count one.
     *         After this swap, determine another swap required or not, if so repeat the swap process again.
     *         if swap not required than proceed to next array element,
     * return the swap number.
     */
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++){
            while (i + 1 != arr[i]){
                int swapIndex = arr[i] -1 ;
                int valAtSwapIndex = arr[swapIndex];
                int valAtIndex = arr[i];
                arr[i] = valAtSwapIndex;
                arr[swapIndex] = valAtIndex;
                swaps++;
            }
        }
        return swaps;
    }
}
