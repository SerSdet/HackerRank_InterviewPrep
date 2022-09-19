package s07_greedyAlgorithms;

import java.util.Arrays;

public class ReverseShuffleMerge {
    public static void main(String[] args) {
        String sample = "abcdefgabcdefg";
        System.out.println(reverseShuffleMergeWithPrints(sample));
        System.out.println(reverseShuffleMerge(sample));
    }

    //To better explanation method with prints also added.

    /**
     * Method finds initial string from final string that was formed by merging reversed and shuffled original string.
     * @param s formed by merging reversed and shuffled initial string.
     * @return original string that was used.
     *
     * First initiate the following integer arrays with size 26. Each index represent one char started from 'a', and
     * value of each index represents how many times that char repeated.
     *         - unUsed array, that store which char's used string
     *         - used array, that store which chars used
     *         - required array, that store which chars required for result string
     *
     * Then initiate result array, which will be used in creating the result string at the end of the method.
     * Its size must be half of the string 's'.
     *
     * After that, fill the unUsed array by using 's' string
     * Then, fill the required array by using unUsed array, every element in the required array is half of unUsed array.
     *
     * For first step, take the last char at string s, and calculate its ascii value and subtracts 'a' to
     * calculate index value in arrays used and unused.
     * Decrease value in unUsed array at that index and increase in used index.
     *
     * After that, go through all chars in 's' as a for loop, that starts from next last char (2nd last at the 's')
     * to the first char of the 's'.
     *         - first check that 'used' value for this char is smaller than 'required' value.
     *                 - If 'used' is smaller it means there is more that char in result string
     *                      But, this string must have bigger ascii value than previous chars so, if it is smaller,
     *                       remove those chars from result string and decrease the value of that chars in 'used' array
     *                      During removal process also used and unused numbers must be checked, if there is no more
     *                       from that letter left, but it is required for the result string then it can not be removed.
     *                      After all characters that have bigger ascii number removed,
     *                      add current char to the 'result' array, decrease the value in 'unUsed' and increase 'used'
     *        - If 'used' value is not smaller than 'required' just decrease the value of char in 'unused' array.
     * After all the chars in 's' aray checked then create the result string from the result array and return
     * it to the main method.
     *
     *
     */

    public static String reverseShuffleMerge(String s) {
        int n = s.length();
        int[] unUsed = new int[26];
        int[] used = new int[26];
        int[] required = new int[26];
        char[] result = new char[n/2];

        for (int i = 0; i < n ; i++){
            unUsed[s.charAt(i) - 'a']++;
        }

        for (int i =0; i < 26; i++ ){
            required[i] = unUsed[i]/2;
        }

        int resultIdx = 0;
        char ch = s.charAt(n - 1);
        int ch_index = ch -'a';
        result[resultIdx++] = ch;
        unUsed[ch_index]--;
        used[ch_index]++;

        for (int i = n - 2 ; i >=0; i--){
            ch = s.charAt(i);
            ch_index = ch -'a';
            if(used[ch_index] < required[ch_index]){
                if (ch <= result[resultIdx - 1]) {
                    while (resultIdx > 0 && ch < result[resultIdx - 1] &&
                            used[result[resultIdx - 1] - 'a'] - 1 + unUsed[result[resultIdx - 1] - 'a'] >= required[result[resultIdx - 1] - 'a']) {
                        used[result[--resultIdx] - 'a']--;
                    }
                }
                result[resultIdx++] = ch;
                unUsed[ch_index]--;
                used[ch_index]++;
            }else{
                unUsed[ch_index]--;
            }

        }
        String res = "";
        for(int i = 0; i < n/2; i++){
            res = res + result[i];
        }

        return res;
    }
    private static String reverseShuffleMergeWithPrints(String s) {
        int n = s.length();
        int[] unUsed = new int[26];
        int[] used = new int[26];
        int[] required = new int[26];
        char[] result = new char[n/2];
        int j = 0;

        char[] sArray = s.toCharArray();

        for (int i = 0; i < n ; i++){
            unUsed[sArray[i] - 'a']++;
        }

        for (int i =0; i < 26; i++ ){
            required[i] = unUsed[i]/2;
        }

        char ch = s.charAt(n - 1);
        int ch_index = ch -'a';
        result[j++] = ch;
        unUsed[ch_index]--;
        used[ch_index]++;
        System.out.print("Before the loop started, result is : ");
        System.out.println(Arrays.toString(result));

        for (int i = n - 2 ; i >=0; i--){
            System.out.println("i : " );
            System.out.println("Checking for result index " + j);
            ch = sArray[i];
            ch_index = ch -'a';
            System.out.println("Looking for the char : " + ch + " and its index is " + ch_index);
            System.out.println("Char '"+ch+"', currently used " + used[ch_index] + " times in in result.");
            System.out.println("Char '"+ch+"', should be used " + required[ch_index] + " times in in result.");
            System.out.println( "Is used is smaller than required  : " +(used[ch_index] < required[ch_index]));
            if(used[ch_index] < required[ch_index]){
                System.out.println(""+ ch + "'is smaller or equals to " + result[j-1] + ": "+ (ch <= result[j - 1]));
                if (ch <= result[j - 1]) {
                    System.out.println("Checking while condition");
                    System.out.println("Is j is bigger than 0 " + (j > 0));
                    System.out.println("Is '"+ ch + "' smaller than " + result[j - 1] +":" +(ch < result[j - 1]));
                    System.out.println("Is '"+ ch +"' used minus one ("+(used[result[j - 1] - 'a'] - 1)+") and unused ("
                            +unUsed[result[j - 1] - 'a']+") is bigger or equal to required ("+(required[result[j - 1] - 'a'])+"): " +
                            (used[result[j - 1] - 'a'] - 1 + unUsed[result[j - 1] - 'a'] >= required[result[j - 1] - 'a']));
                    while (j > 0 && ch < result[j - 1] &&
                            used[result[j - 1] - 'a'] - 1 + unUsed[result[j - 1] - 'a'] >= required[result[j - 1] - 'a']) {
                        used[result[--j] - 'a']--;
                        System.out.println("one element in result removed");
                    }
                }
                result[j++] = ch;
                unUsed[ch_index]--;
                used[ch_index]++;
            }else{
                unUsed[ch_index]--;
            }

            System.out.println(Arrays.toString(result));

        }
        String res = "";
        for(int i = 0; i < n/2; i++){
            res = res + result[i];
        }

        return res;
    }
}
