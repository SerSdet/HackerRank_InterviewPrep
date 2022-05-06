package StringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonChild {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ABDC";

        String s3 = "SHINCHAN";
        String s4 = "NOHARAAA";

        System.out.println(commonChild(s1, s2));
        System.out.println(commonChild(s3, s4));

    }

    /**
     * This algorithm uses Dynamic Programming (remember the matrix solution)
     * First, create the matrix s1 + 1 by s2 +1  chars, in this matrix
     *          first column and row is 0 (remember common string of one char versus null is zero
     * Than, start to fill the chart
     * Finally, return the value in matrix i, j (value in bottom right corner)
     *
     * detailed explanation https://www.youtube.com/watch?v=ASoaQq66foQ&t=463s
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int commonChild(String s1, String s2) {
        // Write your code here
        int[][]lcs = new int [s1.length()+1][s2.length()+1];
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        return lcs[s1.length()][ s2.length()];
    }


}
