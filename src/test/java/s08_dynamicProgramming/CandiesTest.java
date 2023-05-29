package s08_dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandiesTest {
    @Test
    public void testCase_1(){
        Integer[]arr = new Integer[]{2,4,2,6,1,7,8,9,2,1};
        List<Integer> grades = new ArrayList<>(Arrays.asList(arr));
        Assert.assertEquals(Candies.candies(grades.size(), grades), 19);
    }

    @Test
    public void testCase_2(){
        Integer[]arr = new Integer[]{2,4,3,5,2,6,4,5};
        List<Integer> grades = new ArrayList<>(Arrays.asList(arr));
        Assert.assertEquals(Candies.candies(grades.size(), grades), 12);
    }

    @Test
    public void testCase_3(){
        Integer[]arr = new Integer[]{1,2,2};
        List<Integer> grades = new ArrayList<>(Arrays.asList(arr));
        Assert.assertEquals(Candies.candies(grades.size(), grades), 4);
    }
}
