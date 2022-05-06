package Arrays;

import java.util.Arrays;
import java.util.List;

public class NewYearChaos {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {2,1,5,3,4 };
        Integer[] arr2 = new Integer[] {1,2,5,3,7,8,6,4};
        minimumBribes(Arrays.asList(arr1));
        minimumBribes(Arrays.asList(arr2));
    }

    /**
     * @param q the que array that will be checked
     * First,expected condition for first 3 element declared as p1,p2,p3 as 1,2,3.
     *             why only first 3 ? bc, if someone gave more than 2 bribe we will return "too chaotic", so no need to
     *              check more than 3 people.
     * Then, check first element;
     *            - if it is equal to p1 then no one gave the bribe,
     *                for next step increase p1 become p2,p2 become p3 and p3 increase one (+1)
     *            - if it is equal to p2, means 2nd person gave 1 bribe to get this position,
     *                so increase bribe 1, p1 must remain same but p2 and p3 increase 1.
     *            - if it is equal to p3, means 3nd person gave 3 bribe to get this position,
     *               so increase bribe 2, p1, p2 must remain same but p3 increase 1.
     *            - for all others peoples must give more than 2 bribe,
     *               so print "Too chaotic" and end the program.
     * After check all the positions of the array, print out the total number of bribes.
     *
     */
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribe = 0;
        int p1 = 1;
        int p2 = 2;
        int p3 = 3;

        for (int i =0; i < q.size() ; i++ ){
            if (q.get(i) == p1){
                p1 = p2;
                p2 = p3;
                p3++;
            }else if (q.get(i) == p2) {
                p2 = p3;
                p3++;
                bribe++;
            }else if (q.get(i) == p3){
                p3++;
                bribe+=2;
            }else{
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribe);

    }
}
