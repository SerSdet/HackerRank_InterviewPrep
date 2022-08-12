package StacksAndQueues;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 3, 5, 9,6, 11};
        System.out.println(largestRectangle(Arrays.asList(a)));
    }

    /**
     * Method calculates maximum area of the rectangle in the series of buildings (similar to histogram)
     * @param h height of each building (column)
     * @return the maximum area
     * ALGORITHM SUMMARY :
     * Algorithm based on the solution, that maximum area of rectangle must include at least one
     * height of the building compleately.
     * So we will calculate the area for the each building and return maximum of that numbers.
     *
     * For this purpose, we start to put indexes of the building to stack as ascending order.
     *
     * If we found that one building is smaller than previous one, we calculate max area for the
     * buildings taller than that building. Then continue until the end of the array.
     *
     * At the end, we calculate the max area for the buildings that left in stack and
     * return the max area value.
     *
     * STEP BY STEP EXPLANATIONS :
     * First initialize the variable to keep maximum area and the stack, that we will store the indexes of
     * the buildings.
     * Then, we start to the look at the height of each building
     *     - Height of the building at the index that our pointer now stays
     *     - If the stack is empty or current height is larger than index that top on the stack add that index to the stack,
     *          - push that index to the stack
     *     - Else, means new height is smaller than previous one so we need to calculate max Area for the buildings
     *         until we found smaller than current building.
     *          - pop the latest index from the stack,
     *          - height must be height of this building
     *          - If the width is empty, then width will be 'i' if not 'i' minus last index of the stack minus 1
     *          - calculate the area for that building and compare with max area currently stored,
     *          - decrease the 'i' one to check previous building in the stack
     *
     *  After the loop finished, return the max area
     */
    private static long largestRectangle(List<Integer> h) {
        long maxArea = 0L;
        Stack<Integer>indexes = new Stack<>();
        for(int i = 0; i <= h.size(); i++){
            int currentHeight = (i == h.size()) ? 0 : h.get(i);

            if(indexes.isEmpty() || h.get(indexes.peek()) <= currentHeight){
                indexes.push(i);
            }else{
                Integer tempIdx = indexes.pop();
                long height = (long) h.get(tempIdx);
                long width = (indexes.isEmpty() ? i : i- indexes.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
                i--;
            }

        }

        return maxArea;
    }
    private static long largestRectangleWithExplanationsPrints(List<Integer> h) {
        long maxArea = 0L;
        Stack<Integer>indexes = new Stack<>();

        for(int i = 0; i <= h.size(); i++){
            System.out.println("Current indes is :"+ i + " , Loop Started =========================================");
            int currentHeight = (i == h.size()) ? 0 : h.get(i);
            System.out.println("Current Height " + currentHeight);
            System.out.println("is index stack empty ? "+ indexes.isEmpty());
            try {
                Integer topStackIndexHeight = h.get(indexes.peek());
                System.out.println("height at top stack index : " + topStackIndexHeight );
                System.out.println("height in last index is smaller than current height ? " +(h.get(indexes.peek()) +"<=" + currentHeight) +"?"+ (h.get(indexes.peek()) <= currentHeight));
            }catch (Exception e){
                //ignore
            }
            if(indexes.isEmpty() || h.get(indexes.peek()) <= currentHeight){
                indexes.push(i);
                System.out.println("new index pushed to stack, stack now " + indexes);
            }else{
                System.out.println("New height is smaller than previous one so we need to calculate max Area");

                Integer tempIdx = indexes.pop();
                System.out.println("latest index pop from the stack, stack now " + indexes);
                System.out.println("temp index: " + tempIdx);
                System.out.println("Max Area Temp : ");
                long height = (long) h.get(tempIdx);
                System.out.println("Height is previous height in stack : " + height);
                long width = (indexes.isEmpty() ? i : i- indexes.peek() - 1);
                System.out.println("Width is :" + width);
                System.out.println("Temp Max Area is " + height * width);
                maxArea = Math.max(maxArea, height * width);
                System.out.println("Max Area become : " + maxArea);
                System.out.print("current i :" + i );
                i--;
                System.out.println( " become : " + i);
                System.out.println("Loop Ended =========================================");
            }

        }

        return maxArea;
    }
}
