package s03_sorting;

import java.util.Arrays;
import java.util.List;

public class FraudulentActivity {
    public static void main(String[] args) {
        Integer[]arr = new Integer[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
        int d = 5 ;

        System.out.println(activityNotifications(Arrays.asList(arr), d));

    }

    /**
     * This program calculates how many notification will be sent to user after the series of expenditures, which
     * represent shown in Integer array. Credit card limit is 200, so daily expenditure (exp ) must be 0<=exp<=200.
     * @param expenditure array
     * @param d previous number of days for calculation of median expenditures.
     * @return number of notification will be issued
     *
     * First, we create an empty array, which size is 201 (0 to 200) that represent each possible expenditure.
     *        For example if data[10] is 2, there are two times $10 expenditure in previous days for median calculation.
     * Then, put the first d days expenditure in this data array.
     *        For example, if d is [10, 20, 30] than data[10] = 1, data[20] = 1, data[30] = 1
     * Then, start to check with for next loop weather or not notification will be issued in each day d.
     * In each for step :
     *         First, Calculate median (with another sub program, explained below)
     *         Then, check is daily expenditure bigger than median
     *               if it is big then increase notification count by one
     *         Then, change data array by adding that day (d) and remove the oldest day (i-d) expenditure,
     * After the expenditure array finished, return the notification value.
     *
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int notification = 0;
        int[]data = new int[201];

        for (int i  = 0; i < d; i++) {
            data[expenditure.get(i)]++;
        }

        for (int i = d; i < expenditure.size(); i++){
            double median = calcMedian(d, data);
            if(expenditure.get(i) >= 2 * median){
                notification++;
            }
            data[expenditure.get(i)]++;
            data[expenditure.get(i-d)]--;
        }
        return notification;
    }

    /**
     * This program calculate median value for the given array
     * @param d total number of day in the array
     * @param data expenditure array
     * @return the median value
     *
     * data array is sorted expenditure array which represent number of expenditures in total number of days,
     * (NOTE : in series 1,2,3,4,5 median is 3, in series 1,2,3,4 median is (2+3)/2 = 2.5)
     * if d is even number we must find left and right numbers to calculate median
     *     First, initiate count variable to store how many days. And left and right variables to calculate median.
     *     Then, start from the beginning of the array calculate how nay number of days in each expenditure level.
     *           If left equals null and day count is big or equal to d/2 then this index is left (small one) number.
     *           If right equals null and count is equal or grater than d/2 +1 then this index is (bigger one)right number.
     *           (why we use equal or bigger ? bc. if the array is 1,2,2,4 than median will be (2+2)/2 = 2)
     *     After we found right number break from the loop and return the median value
     * if d is odd number,(else case)
     *     First, we start to count the days
     *     When we found count is bigger that d/2 then median is that index value of the data array,
     *     return the median value
     *
     */

    private static double calcMedian(int d, int[] data) {
        double median = 0;
        int count = 0;
        if(d % 2 == 0){ // if d is even
            Integer left = null;
            Integer right = null;
            for(int i = 0; i < data.length; i++){
                count += data[i];
                if(left == null && count >= d/2){
                    left = i;
                }
                if(right == null && count>= d/2 +1){
                    right = i;
                    break;
                }
            }
            median = (left + right) / 2.0;
        }else{ //if d is odd
            for(int i = 0; i < data.length; i++){
                count+=data[i];
                if(count > d/2){
                    median = i;
                    break;
                }
            }
        }
        return median;
    }

}
