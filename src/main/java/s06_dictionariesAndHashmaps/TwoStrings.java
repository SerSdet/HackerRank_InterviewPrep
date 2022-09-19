package s06_dictionariesAndHashmaps;

import java.util.HashSet;

public class TwoStrings {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        System.out.println(twoStrings(s1,s2));
    }

    /**
     * Method return "YES" if two string has some common substring (even the length is 1) otherwise "NO"
     * @param s1 first string
     * @param s2 second string
     * @return "YES" or "NO"
     *
     * We search at least one common character so :
     * First, create Character hashSet for each string,
     * Then, put the characters of each string into these hashSets
     * After that, delete all characters in s1 hashSet that are not exist in s2 hashSet. (by using retainAll functinon)
     * Then check if any character in s1 left, if so these characters are common for both of s1 and s2
     * if all the characters deleted from the hashSet (means no common character exists", then return "NO"
     *    otherwise return "YES"
     */
    public static String twoStrings(String s1, String s2) {
        // Write your code here
        HashSet<Character>s1_chars = new HashSet<>();
        HashSet<Character>s2_chars = new HashSet<>();

        for (int i = 0; i < s1.length(); i++){
            s1_chars.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++){
            s2_chars.add(s2.charAt(i));
        }

        s1_chars.retainAll(s2_chars);

        if(s1_chars.isEmpty()){
            return "NO";
        }else{
            return "YES";
        }
    }
}
