package s08_dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class MaxArraySumTest {
    @Test
    public void testCase_1() {
        int[] arr = new int[]{-2, -1, -3, -4, -5};
        Assert.assertEquals(0, MaxArraySum.maxSubsetSum(arr));
    }

    @Test
    public void testCase_2() {
        int[] arr = new int[]{3, 5, -7, 8, 10};
        Assert.assertEquals(15, MaxArraySum.maxSubsetSum(arr));
    }

    @Test
    public void testCase_3() {
        int[] arr = new int[]{2, 1, 5, 8, 4};
        Assert.assertEquals(11, MaxArraySum.maxSubsetSum(arr));
    }

    @Test
    public void testCase_4() {
        int[] arr = new int[]{3, 7, 4, 6, 5};
        Assert.assertEquals(13, MaxArraySum.maxSubsetSum(arr));
    }
}
