package GreedyAlgorithms;



import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckBalanceTest {

    @Test
    public void test_1(){
        int n = 6;
        Integer[][] input = new Integer[][]{{5,1},{2,1},{1,1},{8,1},{10,0}, {5,0}};
        List<List<Integer>> contest = new ArrayList<>();
        for (int i = 0; i < n ; i++){
            contest.add(Arrays.asList(input[i]));
        }
        int k = 3;
        Assert.assertEquals(29, LuckBalance.luckBalance(k,contest));
    }
}
