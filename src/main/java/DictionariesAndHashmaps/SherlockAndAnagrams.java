package DictionariesAndHashmaps;

import java.util.Arrays;
import java.util.HashMap;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        String anagram1 = "serdar";
        String anagram2 = "kkkk";
        System.out.println(sherlockAndAnagrams(anagram1));
        System.out.println(sherlockAndAnagrams(anagram2));
    }

    /**
     * Method return total number of anagram substring pairs in string 's'
     * @param s String 's'
     * @return total number of anagram pairs.
     *
     * Anagram : consists from same letters
     * First, create each sub-string for string
     *       - create char array and sort  it
     *       - put this char array into hash map and count the repeat of the string
     * Then, for each substring calculate 2 pair combination of each sub-string
     * Finally, return the total number of pairs.
     */
    public static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> subStrs = new HashMap<>();

        for(int i = 0 ; i <s.length(); i++){
            for (int j=i; j < s.length(); j++){
                char[]c = s.substring(i, j+1).toCharArray();
                Arrays.sort(c);
                String ss = new String(c);
                if(subStrs.containsKey(ss)){
                    subStrs.put(ss,subStrs.get(ss) + 1);
                }else{
                    subStrs.put(ss,1);
                }
            }
        }
        int count = 0;
        for(String k: subStrs.keySet()){
            int v = subStrs.get(k);
            int stringPairs = (v * (v - 1))/2;
            count +=stringPairs;
        }
        return count;
    }

    //Another way to identify substrings are assigning chars to prime numbers,
    //after that if we look at the results of multiplication of the assigned numbers
    //only anagram substrings have same product. code below is create an array for first 26 prime numbers.
}
