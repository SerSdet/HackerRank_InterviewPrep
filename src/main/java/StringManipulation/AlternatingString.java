package StringManipulation;

public class AlternatingString {
    public static void main(String[] args) {
        String s = "AABAAB";
        System.out.println(alternatingCharacters(s));
    }

    /**
     *
     * @param s
     * @return
     */
    public static int alternatingCharacters(String s) {
        // Write your code here
        int delCount = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                delCount++;
            }
        }
        return delCount;
    }
}
