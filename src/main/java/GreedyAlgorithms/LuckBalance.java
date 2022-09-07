package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LuckBalance {
    public static void main(String[] args) {
        int n = 6;
        Integer[][] input = new Integer[][]{{5,1},{2,1},{1,1},{8,1},{10,0}, {5,0}};
        List<List<Integer>> contest = new ArrayList<>();
        for (int i = 0; i < n ; i++){
            contest.add(Arrays.asList(input[i]));
        }
        int k = 3;
        System.out.println(luckBalance(k, contest));
        System.out.println(luckBalance2(k, contest));
    }

    /**
     * Method gives the maximum luck balance of user, if user lost luck balance increase and user can only lose
     * 'k' number of important contest.
     * @param k number of contest user can lose
     * @param contests every contest has two value (Luck, Importance) importance 1 means important 0 not.
     * @return luck balance at the end of competition
     *
     * First, sort the contest array according to luck number in descending order by using comparator class.
     * Then go through each competition by using for loop,
     *      - If importance is '0' lost the competition and increase the luck balance
     *      - Else, check the k value if it is bigger than 0 then it can be lost so
     *        increase the luck balance and decrease k one,
     *      otherwise decrease the luck balance as contest requires.
     */
    public static int luckBalance (int k , List<List<Integer>> contests){
        int luckBalance = 0;

        contests.sort(new Comparator<List<Integer>>(){
            public int compare (List <Integer> o1, List<Integer> o2) {
                return -1 * Integer.compare(o1.get(0), o2.get(0));
            }
        });

        for (List<Integer>match : contests){
            Integer luck = match.get(0);
            Integer importance = match.get(1);
            if (importance == 0){
                luckBalance += luck;
            }else{
                if(k > 0){
                    k--;
                    luckBalance += luck;
                }else{
                    luckBalance -= luck;
                }
            }
        }
        return luckBalance;
    }

    public static int luckBalance2 (int k , List<List<Integer>> contests){
        List<Integer> important = new ArrayList<>();
        int luckSum = 0;
        for (int i = 0; i < contests.size(); i++){
            if(contests.get(i).get(1) == 1){
                important.add(contests.get(i).get(0));
            }else{
                luckSum += contests.get(i).get(0);
            }
        }

        important.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -1 * Integer.compare(o1,o2);
            }
        });

        for (int i = 0; i < important.size(); i++){
            if(k > 0 ){
                luckSum += important.get(i);
                k--;
            }else{
                luckSum -= important.get(i);
            }
        }

        return luckSum;
    }
}
