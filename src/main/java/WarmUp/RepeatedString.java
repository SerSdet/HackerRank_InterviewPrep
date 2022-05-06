package WarmUp;

public class RepeatedString {
    public static void main(String[] args) {
        String s = "aba";
        long n = 10l;
        System.out.println(repeatedString(s, n));
    }

    /**
     *
     * @param s string that will repeat
     * @param n number of character that we calculate, so :
     *             is string is "abc" and n 10 string will be "abcabcabca" (3 times string and 1 character)
     * @return number of a's in the string
     *
     * first, calculate how many times string repeat by division operation,
     * then, how many characters of string added to this number of repeats by mod operation,
     * after that, calculate how many a's in remainder part and in a string,
     * finally, calculate total number by repeat time and a's in the string and add a's in remaining part to this number
     *
     */
    public static long repeatedString(String s, long n) {
        // Write your code here
        long totalStringRepeat = n / s.length();
        int remainder = (int) (n % s.length());
        long stringCount = 0;
        long remCount = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < remainder; i ++) {
            if (c[i] == 'a') stringCount ++;
        }
        remCount = stringCount;
        for (int i = remainder; i < s.length(); i ++) {
            if (c[i] == 'a') stringCount ++;
        }

        return stringCount*totalStringRepeat + remCount;


    }
}
