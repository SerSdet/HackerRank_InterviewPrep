package GreedyAlgorithms;

import org.junit.Assert;
import org.junit.Test;

public class GreedyFloristTest {
    @Test
    public void test1(){
        int k = 3;
        int[] c = new int[]{1, 3, 5, 7, 9};
        Assert.assertEquals(29, GreedyFlorist.getMinimumCost(k,c));
    }
    @Test
    public void test2(){
        int k = 3;
        int[] c = new int[]{2, 5, 6};
        Assert.assertEquals(13, GreedyFlorist.getMinimumCost(k,c));
    }
    @Test
    public void test3(){
        int k = 2;
        int[] c = new int[]{2, 5, 6};
        Assert.assertEquals(15, GreedyFlorist.getMinimumCost(k,c));
    }

}
