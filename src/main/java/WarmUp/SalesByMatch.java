package WarmUp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Use Set to store unique values,
 * if you find a value which already added to Set it means you find a new pair,
 * increase count one and remove the value from the set,
 * if you find a value, which is not in the set, means you have one sock without a pair,
 * add this value to the set.
 * At the end of the array return the count of pairs.
 */

public class SalesByMatch {
    public static void main(String[] args) {
        Integer[] socks = new Integer[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        List<Integer> arr = Arrays.asList(socks);
        System.out.println(sockMerchant(socks.length, arr));
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int count = 0 ;
        HashSet<Integer> ones = new HashSet<>();
        for (Integer sock : ar) {
            if (ones.contains(sock)){
                count++;
                ones.remove(sock);
            }else{
                ones.add(sock);
            }
        }
        return count;
    }
}
