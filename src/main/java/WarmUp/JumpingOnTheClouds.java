package WarmUp;

import java.util.Arrays;
import java.util.List;

public class JumpingOnTheClouds {
    public static void main(String[] args) {
        Integer[] sample = new Integer[]{0, 0, 1, 0, 0, 1, 0};

        System.out.println(jumpingOnClouds(Arrays.asList(sample)));
    }

    /**
     * Always try to jump two steps, unless ,
     *     one step left in the series
     *     or
     *     i+2ht step cloud has electricity (means equal to 1)
     *
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int count = 0;
        int i = 0;

        while (i < c.size()-1){
            if (i+2 == c.size() || c.get(i+2)==1){
                i++;
                count++;
            }else{
                i+=2;
                count++;
            }
        }
        return count;
    }

}
