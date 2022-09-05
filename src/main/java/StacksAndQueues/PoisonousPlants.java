package StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PoisonousPlants {
    public static void main(String[] args) {

        Integer[]plantsArray = new Integer[]{6, 5, 8, 4, 7, 10, 9};
        Integer[]plantsArray2 = new Integer[]{4, 3, 7, 5, 6, 4, 2};

        ArrayList<Integer> plants = new ArrayList<>(Arrays.asList(plantsArray2));

        System.out.println(poisonousPlants(plants));
    }

    /**
     * Method gives the number of days which there is no plant with more pesticide content than the plant to its left
     * @param p amount of pesticide for each plant
     * @return number of days
     *
     * Algorithm based on use of the stack. Method save array numbers in stack that are more than previous ones,
     * if new array number is smaller than elements on top of the array, then remove them from the stack and
     * pass their time value to current element (time on ly increase !).
     * After targeted amount of days, array should become decreasing order.
     *
     * First, Stack, for saving index number of increased pesticide plants, maximum day variable, which wil return to
     * main method and array to store time must be created.
     *
     * Then loop started from first element of the array,
     *       - First, while current element in array is smaller than or equal to top element on the index stack,
     *       remove element from the stack and assign current time as bigger value of current time value or
     *       time value at correspond to index at stack.
     *       ( this will continue as long as there is element in stack or
     *       element on the stack is smaller than current element)
     *
     *       - Then, if any element still exist in stack increase current time value '1' and update max time value.
     *
     *       - Finally, push the current index to the stack.
     *
     * After the loop finished, return the max time value to main method.
     */

    public static int poisonousPlants(List<Integer> p){

        Stack<Integer> indexes = new Stack<>();
        int[]time = new int [p.size()];
        int maxDays = 0;

        for (int i = 0; i < p.size(); i++){
            System.out.println(i);
            while(!indexes.empty() && p.get(indexes.peek()) >= p.get(i)){
                time[i] = Math.max(time[i], time[indexes.pop()]);
            }

            if(!indexes.empty()){
                time[i] = time[i] + 1;
            }

            maxDays = Math.max(maxDays, time[i]);
            indexes.push(i);

            System.out.println(indexes);
        }
        return maxDays;
    }
}
