package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class MinMaxRiddle {
    public static void main(String[] args) {
        long[] arr = new long[]{10,20,30,50,10,70,30};


        System.out.println(Arrays.toString(riddle(arr)));
//        System.out.println(Arrays.toString(riddle2(arr)));
//        System.out.println(Arrays.toString(riddle3(arr)));
    }

    /**
     *
     * @param arr
     * @return
     *
     * First create results and span arrays,
     *      - result array will store final results and returned,
     *      - span array will store for each element what is the largest index of array that element is minimum
     *
     * Then, create two stacks called values and indexes
     * After that push '-1' to indexes (it will represent left of first element in indexes)
     *
     * To span values for each element will be calculated for both left and right sides, in each run elements, which are
     * smaller than arr[i] will be calculated
     *
     * First, span for the left will be calculated;
     * In order to calculate left span, loop through parameter array started from first element
     *      - First, if the element on top of the stack is greater or equal to current array element
     *              than remove that element's value from values stack and remove onr index value
     *      - Then calculate the span value for that element as follows:
     *             current index value minus last index value (which belongs to smaller than current element) on the stack
     *             and minus 1 because we want to calculate span as index.
     *      - Finally, put value and index of the element to the stack
     *
     * Then, span for the left will be calculated;
     * First, clear the values remain in values and indexes stacks
     *
     * In order to calculate right span, loop through array from the last element to first
     *      Loop logic is similar to first loop but only difference is how we calculate span,
     *      - First, if the element on top of the stack is greater or equal to current array element
     *              than remove that element's value from values stack and remove onr index value
     *      - Then calculate the span value for that element as follows:
     *             last index value (which belongs to smaller than current element) on the stack current minus index value
     *             and minus 1 because we want to calculate span as index,
     *             we add this number to previous number in the stack array.
     *     - Finally, put value and index of the element to the stack
     *
     * After span values calculated we start to put results into result array,
     *
     * Start from 0 to array length - 1 start to put the results to results array
     *      - First, result index, which the value will be put, is the span value of current index,
     *      - Then compare the value that is currently on result with element at index in array and put the greater one
     *              to the result index
     *
     * After filling these results some values may be missing in result array, these results must be filled as this,
     *      start from the end loop through the result array and compare the result array element with right next to it
     *      and update the number if right next one greater than current value.
     *
     */

    static long[] riddle(long[] arr) {
        int n = arr.length;
        long[] result = new long[n];
        long[] span = new long[n]; //for each element what is the largest index of array that element is minimum

        Stack<Long> values = new Stack<>();
        Stack<Long> indexes = new Stack<>();
        indexes.push(-1L);

        for (int i = 0; i < n ; i++ ) {
            try {
                boolean tmp = values.peek() >= arr[i];
            } catch (Exception e) {
                //ignore
            }
            while (!values.isEmpty() && values.peek() >= arr[i]) {
                values.pop();
                indexes.pop();
                try {
                    boolean tmp = values.peek() >= arr[i];
                } catch (Exception e) {
                    //ignore
                }
            }
            span[i] = i - indexes.peek() - 1;
            values.push(arr[i]);
            indexes.push((long) i);
        }
        values.clear();
        indexes.clear();
        indexes.push((long) n);

        for (int i = n - 1; i >= 0; i--) {
            try{
                boolean tmp = values.peek() >= arr[i];
            }catch (Exception e){
                //ignore
            }
            while (!values.isEmpty() && values.peek() >= arr[i]) {
                values.pop();
                indexes.pop();
                try{
                    boolean tmp = values.peek() >= arr[i];
                }catch (Exception e){
                //ignore
                }
            }
            span[i] += indexes.peek() - i - 1;
            values.push(arr[i]);
            indexes.push((long) i);
        }

        for (int i = 0 ; i <n ; i++ ){
            int resIndex = (int) span[i];
            long arrayTemp =  arr[i];
            long tempElement = result[resIndex];
            result[resIndex] = Math.max(tempElement, arrayTemp);
        }
        for (int i = n-2; i >= 0; i--){
            result[i] = Math.max(result[i], result[i + 1]);
        }
        return result;
    }

//Lots of print statement to understand how algorithm works.
    static long[] riddleWithLotOfPrints(long[] arr) {
        int n = arr.length;
        long[] result = new long[n];
        long[] span = new long[n]; //for each element what is the largest index of array that element is minimum

        Stack<Long> values = new Stack<>();
        Stack<Long> indexes = new Stack<>();
        indexes.push(-1L);

        for (int i = 0; i < n ; i++ ) {
            System.out.println(i + " : =================");
            try {
                boolean tmp = values.peek() >= arr[i];
                System.out.println(values.peek() + " >= " + arr[i] + " : " + tmp);
            } catch (Exception e) {
                System.out.println("No element in values");
            }
            while (!values.isEmpty() && values.peek() >= arr[i]) {

                values.pop();
                indexes.pop();
                System.out.println("one value and index poped");
                try {
                    boolean tmp = values.peek() >= arr[i];
                    System.out.println(values.peek() + " >= " + arr[i] + " : " + tmp);
                } catch (Exception e) {
                    System.out.println("No element in values");
                }
            }
            System.out.print("span is " + i + "-" + indexes.peek() + "-1 = ");
            span[i] = i - indexes.peek() - 1;
            System.out.println( span[i]);
            values.push(arr[i]);
            indexes.push((long) i);
            System.out.println(Arrays.toString(span));
            System.out.println(indexes);
            System.out.println(values);
        }

        System.out.println("clear the values and indexes");
        values.clear();
        indexes.clear();
        indexes.push((long) n);
        System.out.println();
        System.out.println(indexes);
        System.out.println(values);


        for (int i = n - 1; i >= 0; i--) {
            System.out.println(i + " : =================");
            try{
                boolean tmp = values.peek() >= arr[i];
                System.out.println(values.peek() + " >= " + arr[i] + " : " + tmp);
            }catch (Exception e){
                System.out.println("No element in values");
            }
            while (!values.isEmpty() && values.peek() >= arr[i]) {
                values.pop();
                indexes.pop();
                try{
                    boolean tmp = values.peek() >= arr[i];
                    System.out.println(values.peek() + " >= " + arr[i] + " : " + tmp);
                }catch (Exception e){
                    System.out.println("No element in values");
                }
            }
            System.out.print("span is " + indexes.peek() + "-" + i + "-1 = ");
            span[i] += indexes.peek() - i - 1;
            System.out.println( span[i]);
            values.push(arr[i]);
            indexes.push((long) i);
            System.out.println(Arrays.toString(span));
            System.out.println(indexes);
            System.out.println(values);
        }

        for (int i = 0 ; i <n ; i++ ){
            int resIndex = (int) span[i];
            long arrayTemp =  arr[i];
            long tempElement = result[resIndex];
            result[resIndex] = Math.max(tempElement, arrayTemp);
        }
        for (int i = n-2; i >= 0; i--){
            result[i] = Math.max(result[i], result[i + 1]);
        }
        return result;
    }
}
