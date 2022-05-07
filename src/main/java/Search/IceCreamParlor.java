package Search;

import java.util.Arrays;
import java.util.List;

public class IceCreamParlor {
    public static void main(String[] args) {
        Integer[] flArray = new Integer[]{1, 4, 5, 3, 2};
        int money = 4;
        whatFlavors(Arrays.asList(flArray), money);
    }

    /**
     * Find two ice cream flavour that complement each other, each day you have only ONE solution
     * @param cost daily budget for ice cream
     * @param money menu order of the flavours (not index, so they start from 1 and menu isn't sorted)
     *
     * First, create the copy of the menu and put ut to the array
     * Then, sort the array using Arrays.sort function
     * Then, from start of the sorted menu array find whether item has compliment (money - item) by
     *        using Binary Search in java (detailed info : https://www.geeksforgeeks.org/binary-search/)
     * If binary search give index (it gives -1 if array doesn't include that number),(no need to search previous numbers)
     *        some bugs must also be eliminated, so check the conditions below:
     *        check the number is smaller than the size of the array (binary search may give index that may include in array)
     *        check value in the menu location equal to compliment number.
     *    If these conditions satisfied, then find the indexes of these flavours in original menu array,
     *        which will be done with another subprogram (explained below) and add +1 to find menu order.
     *    Finally, return the flavours in ascending order.
     *
     */

    public static void whatFlavors(List<Integer> cost, int money) {
        // Write your code here
        Integer[] sortedMenu = cost.toArray(new Integer[0]);
        Arrays.sort(sortedMenu);
        for (int i = 0; i < sortedMenu.length; i++){
            int compliment = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu,i+1,sortedMenu.length, compliment);
            if (location >=0 && location < sortedMenu.length && sortedMenu[location] == compliment){
                int indexFlavour1 = indexOf(cost, sortedMenu[i], -1);
                int indexFlavour2 = indexOf(cost, compliment, indexFlavour1);
                int loc1 = Math.min(indexFlavour1, indexFlavour2) + 1;
                int loc2 = Math.max(indexFlavour1, indexFlavour2) + 1;
                System.out.println(loc1 + " " + loc2);
            }
        }

    }

    /**
     * Find original index of the flavour
     * @param cost original menu array
     * @param value1 is the value that we are looking for its index
     * @param excludeThis excluded value (if two flavour has the same price,
     *                    this option will be used to avoid getting same index)
     * @return index of the flavour in the menu
     */

    private static int indexOf(List<Integer>cost, int value1, int excludeThis){
        for (int i = 0; i < cost.size(); i++){
            if(cost.get(i)==value1 && i!= excludeThis){
                return i;
            }
        }
        return -1;
    }
}
