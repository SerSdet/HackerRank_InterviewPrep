package s04_stringManipulation;

public class SpecialStringAgain {
    public static void main(String[] args) {
        String s = "asasd";
        System.out.println(substrCount(s.length(), s));
    }

    /**
     *
     * @param n length of the string
     * @param s string, that will test
     * @return number of special substrings (all chars are same or only middle char is different), in test string
     * Start with first char of the string and check;
     *      -if next char is not same,
     *             then check
     *                  if current substring is same after the different char increase count one and break,
     *                  else break without increase count.
     *       else (means both char same)
     *            increase word count one and check for next char of the string
     */

    static long substrCount(int n, String s) {
        long ans = n;
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n ; j++){
                if(s.charAt(i) != s.charAt(j)){
                    if (( 2*j -i < n ) && (s.substring(i,j).equals(s.substring(j+1, ((2*j) - i) + 1)))){
                        ans++;
                        break;
                    }else{
                        break;
                    }
                }else{
                    ans++;
                }
            }
        }
        return ans;
    }
}
