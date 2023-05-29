package s08_dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class AbbreviationTest {
    @Test
    public void testCase_1(){
        String a = "";
        String b = "";
        Assert.assertEquals(Abbreviation.abbreviation(a,b),"YES");
    }
    @Test
    public void testCase_2(){
        String a = "Pi";
        String b = "P";
        Assert.assertEquals(Abbreviation.abbreviation(a,b),"YES");
    }

    @Test
    public void testCase_3(){
        String a = "AfPZN";
        String b = "APZNC";
        Assert.assertEquals(Abbreviation.abbreviation(a,b),"NO");
    }

    @Test
    public void testCase_4(){
        String a = "sYOCa";
        String b = "YOCN";
        Assert.assertEquals(Abbreviation.abbreviation(a,b),"NO");
    }

    @Test
    public void testCase_5(){
        String a = "beFgH";
        String b = "EFG";
        Assert.assertEquals(Abbreviation.abbreviation(a,b),"NO");
    }


}
