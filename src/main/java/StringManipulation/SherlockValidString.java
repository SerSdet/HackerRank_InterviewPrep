package StringManipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class SherlockValidString {
    public static void main(String[] args) {
        //String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        String s = "abcdefghhgfedecba";
        System.out.println(isValid(s));
    }

    /**
     *
     * @param s
     * @return
     * First, count that each letter repeat how many times,
     * Then, find min and max values of repetition,
     * Then, check if min and max values are equal, if so answer is YES,
     * Then, count min and max values and store as minCount and maxCount,
     * Then, do the final check:
     *      - if total count min and max count are not equal to letter used in string,
     *          means there is another number in min and max, so return NO,
     *      - if minCount is 1 or
     *              maxCount is only one more than min and maxCount is 1
     *          then return YES,
     *       otherwise
     *          return NO,
     */
    public static String isValid(String s) {
        // Write your code here
        HashMap<Character, Integer> mapString = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character key = s.charAt(i);
            if(mapString.containsKey(key)){
                mapString.put(key, mapString.get(key)+ 1);
            }else{
                mapString.put(key, 1);
            }
        }
        ArrayList<Integer> mapValues = new ArrayList<>(mapString.values());
        int min = (int) Collections.min(mapValues);
        int max = (int) Collections.max(mapValues);

        if (max == min ){
            return "YES";
        }
        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < mapValues.size(); i++){
            if(mapValues.get(i) == max){
                maxCount++;
            }else if (mapValues.get(i) == min){
                minCount++;
            }
        }

        if ((maxCount + minCount) != mapValues.size()) {
            return "NO";
        }
        if (minCount == 1  || (maxCount == 1 && max == min + 1 )){
            return "YES";
        }else {
            return "NO";
        }
    }
}
