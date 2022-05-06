package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Integer[] ar = new Integer[] {1,4,6,8,2,5,7,9,10};
        List<Integer> arr = Arrays.asList(ar);
        long inversions = 0;
        int n = arr.size();
        int mid = n/2;
        List<Integer>left = new ArrayList<>(arr.subList(0,mid));
        List<Integer>right = new ArrayList<>(arr.subList(mid,n));
        int range = n - mid;
        int iLeft = 0;
        int iRight = 0;

        for (int i = 0; i < n; i++){
            if((iLeft < mid) && (iRight >=range || left.get(iLeft) <= right.get(iRight))){
                arr.set(i,left.get(iLeft));
                iLeft++;
                inversions += iRight;
            }else if (iRight < range){
                arr.set(i, right.get(iRight));
                iRight++;
            }
        }
        System.out.println(inversions);
    }
}
