package s01_arrays;

import java.util.Arrays;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,4,5};
        System.out.println(rotLeft(Arrays.asList(a), 2));
    }

    /**
     * @param a Array
     * @param d how many step array will be rotated to the left (d always smaller than array size)
     * @return rotated array
     *
     * First create the array for new rotated array,
     * Then, fill the rotated array started from the beginning, from the 'd'th element of the original array
     * After that reset the
     *
     */
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        Integer[] rotated = new Integer[a.size()];
        int i = 0;
        int rotateIndex = d;

        while ( rotateIndex < a.size()) {
            rotated[i] = a.get(rotateIndex);
            i++;
            rotateIndex++;
        }
        rotateIndex = 0;
        while ( rotateIndex < d) {
            rotated[i] = a.get(rotateIndex);
            i++;
            rotateIndex++;
        }

        return Arrays.asList(rotated);
    }

}
