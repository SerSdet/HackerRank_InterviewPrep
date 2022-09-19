package s07_greedyAlgorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxMinTest {

    @Test
    public void test1(){
        Integer[]sample = new Integer[]{100 ,200, 300,350,400,401,402};
        List<Integer> arr = new ArrayList<>(Arrays.asList(sample));
        int k = 3;
        Assert.assertEquals(2, MaxMin.maxMin(k,arr));
    }

    @Test
    public void test2(){
        Integer[]sample = new Integer[]{10,100,300,200,1000,20,30};
        List<Integer> arr = new ArrayList<>(Arrays.asList(sample));
        int k = 3;
        Assert.assertEquals(20, MaxMin.maxMin(k,arr));
    }

    @Test
    public void test3(){
        Integer[]sample = new Integer[]{1,2,3,4,10,20,30,40,100,200};
        List<Integer> arr = new ArrayList<>(Arrays.asList(sample));
        int k = 4;
        Assert.assertEquals(3, MaxMin.maxMin(k,arr));
    }

    @Test
    public void test4(){
        Integer[]sample = new Integer[]{1 ,2, 1,2,1};
        List<Integer> arr = new ArrayList<>(Arrays.asList(sample));
        int k = 2;
        Assert.assertEquals(0, MaxMin.maxMin(k,arr));
    }
}
