package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDArray {
    public static void main(String[] args) {
        Integer[]line1 = new Integer[] {-9,-9,-9,1,1,1};
        Integer[]line2 = new Integer[] {0,-9,0,4,3,2};
        Integer[]line3 = new Integer[] {-9,-9,-9,1,2,3};
        Integer[]line4 = new Integer[] {0,0,8,6,6,0};
        Integer[]line5 = new Integer[] {0,0,0,-2,0,0};
        Integer[]line6 = new Integer[] {0,0,1,2,4,0};
        List<List<Integer>>arr = new ArrayList<>();
        arr.add(Arrays.asList(line1));
        arr.add(Arrays.asList(line2));
        arr.add(Arrays.asList(line3));
        arr.add(Arrays.asList(line4));
        arr.add(Arrays.asList(line5));
        arr.add(Arrays.asList(line6));

        System.out.println(hourglassSum(arr));
    }

    /**
     * Input will be 6X6 Array , so we will calculate according to this
     *
     * @param arr
     * @return
     */
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int sumMax = Integer.MIN_VALUE;
        for (int i = 0 ; i < 4; i++){
            for(int j = 0 ; j < 4; j++){
                int temp =  arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2) +arr.get(i+1).get(j+1) +arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2);
                sumMax = Math.max(sumMax,temp);
            }
        }
        return sumMax;
    }
}
