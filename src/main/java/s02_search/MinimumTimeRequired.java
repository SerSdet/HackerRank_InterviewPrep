package s02_search;

import java.util.Arrays;

public class MinimumTimeRequired {
    public static void main(String[] args) {
        long[]machines = new long[]{4,5,6};
        long target = 12;
        System.out.println(minTime(machines,target));
    }

    /**
     * Return minimum number of days for target production number
     * @param machines array that represent required day for unit for each machine (3 means 3 day req. for 1 unit)
     * @param goal production goal
     * @return number of days to reach that production
     *
     * First, sort the machine array so the fastest machine index will 0 and slowest one at the end of the array
     * Then, initialize minimum (at least 1 day ) and maximum (production day with the slowest machine) number of days
     * Then, initialize production count and middle number
     * Start a loop while min and max are not equal
     *      - first calculate mid number according to min and max number
     *      - calculate production (with another method) at mid number day,
     *      - if calculated production bigger or equal to the goal,
     *          then it means searched day on left side so, mid become max,
     *         else
     *          it means searched day on rigth side so, min become mid + 1
     *      do this loop until min = max, that number is the minimum required day for production
     */
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long min = 1;
        long max = machines[machines.length - 1] * goal;

        long prodCount = 0;
        long mid = 0;

        while (min != max){
            mid = (min + max) / 2;
            prodCount = prodCount(mid, machines);
            if(prodCount >= goal){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }

    /**
     * This method calculates production number in certain day
     * @param dayNumber day that production will be calculated
     * @param machines machine production array
     * @return number of finished products at dayNumber
     *
     * Go through the machine array and calculate the production number for each machine at that day.
     * Each day produce dayNumber divided by array number of products for that day
     * return the sum of this productions
     */
    private static long prodCount(long dayNumber, long[]machines){
        long prodCount = 0;
        for (long i : machines){
            prodCount += (dayNumber/i);
        }
        return prodCount;
    }

}
