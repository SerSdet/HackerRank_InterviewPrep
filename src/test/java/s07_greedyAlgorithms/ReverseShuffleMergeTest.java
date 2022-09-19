package s07_greedyAlgorithms;

import org.junit.Assert;
import org.junit.Test;

public class ReverseShuffleMergeTest {
    @Test
    public void test_1(){
        Assert.assertEquals("egg",ReverseShuffleMerge.reverseShuffleMerge("eggegg"));
    }

    @Test
    public void test_2(){
        Assert.assertEquals("agfedcb",ReverseShuffleMerge.reverseShuffleMerge("abcdefgabcdefg"));
    }

    @Test
    public void test_3(){
        Assert.assertEquals("aeiou",ReverseShuffleMerge.reverseShuffleMerge("aeiouuoiea"));
    }
}
