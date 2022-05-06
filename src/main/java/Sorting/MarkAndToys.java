package Sorting;

import java.util.Arrays;
import java.util.List;

public class MarkAndToys {
    public static void main(String[] args) {
        Integer[]arr = new Integer[]{1, 12, 5, 111, 200, 1000, 10,};
        int k = 50;
        System.out.println(maximumToys(Arrays.asList(arr), k));
    }

    /**
     *
     * @param prices list of toy prices,
     * @param k bugget of max
     * @return maximum number of toys, Mark can buy
     *
     * For maximum number of toys, Mark should buy the cheapest toys first
     *
     * First, we put the list to array, because we want to use sorting function of java for arrays
     * Than, new array sorted as ascending order.
     * Then, start from the first element of the array, which is the cheapest one, start to buy.
     *      In each purchase we must check the budget, if budget is less than current price,
     */

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        Integer toyCount = 0;
        if(prices.size() == 0 || k == 0) {
            return toyCount;
        }

        Integer[]arr = new Integer[prices.size()];
        prices.toArray(arr);
        Arrays.sort(arr);
        for(int i = 0; i< arr.length; i++){
            k-=arr[i];
            if (k < 0) {
                return toyCount;
            }else{
                toyCount++;
            }
        }

        return toyCount;

    }
}
