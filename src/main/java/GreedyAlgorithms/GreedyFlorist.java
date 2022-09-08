package GreedyAlgorithms;

import java.util.Arrays;

public class GreedyFlorist {
    public static void main(String[] args) {
        int k = 3;
        int[] c = new int[]{1, 3, 5, 7, 9,};
        System.out.println(getMinimumCost(k,c));
    }

    /**
     * Return minimum total cost
     * @param k number of people
     * @param c flower cost array
     * @return minimum cost
     *
     * To minimize the total cost, each person should buy most expensive flower first for this
     * First, cost array sorted
     * Then for loop started from at the end of the array to beginning (so most expensive ones first)
     *      Calculate each flower cost added to bill
     * Return total bill.
     */
    public static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int bill = 0;
        int n = c.length - 1;
        for (int i = n; i>= 0; i--){
            int flowerCost = (((n - i)/k) + 1) * c[i];
            bill += flowerCost;
        }
        return bill;
    }
}
