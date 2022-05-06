package StringManipulation;

public class MakingAnagrams {
    public static void main(String[] args) {
        String a = "cde";
        String b = "abc";

        System.out.println(makeAnagram(a,b));
    }

    /**
     *
     * @param a
     * @param b
     * @return number of deletion required to make anagram
     * First, count the characters in each string. For this purpose use one array which length is 26
     *  26 is the number of letters in english alphabet, each position is for one char and numbers represent how many
     *  times that char repeated.
     *
     * Than, find the difference of this two array and return as number of required deletion
     */

    public static int makeAnagram(String a, String b) {
        // Write your code here
        int deletion = 0;

        int[] a_freq = new int[26];
        int[] b_freq = new int[26];

        for (int i = 0;  i < a.length(); i++){
            char currentChar = a.charAt(i);
            int char_ascii = (int)currentChar;
            int position = char_ascii - (int) 'a';
            a_freq[position]++;
        }
        for (int i = 0;  i < b.length(); i++){
            char currentChar = b.charAt(i);
            int char_ascii = (int)currentChar;
            int position = char_ascii - (int) 'a';
            b_freq[position]++;
        }
        for(int i = 0; i < 26; i++){
            int difference = Math.abs(a_freq[i]-b_freq[i]);
            deletion = deletion + difference;
        }

        return deletion;

    }
}
