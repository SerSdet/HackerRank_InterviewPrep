package DictionariesAndHashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RansomNote {
    public static void main(String[] args) {
        String mag = "zahk dp apdz clo e dk awfvf osb qr sa cqjq zgr nvxtb abjy axa ili wdyw soqku buwcl qcub sautu ii vkrzl bdob nona al zg ombzc c dbun f xkuo lsax hfki j dfft uce ugj ywz vucgg xq udrkt ypy tmxgc ty gar kty dc bznj pzzx clo apdz nvxtb clo sa clo zahk awfvf soqku udrkt udrkt e ypy xkuo tmxgc ombzc wdyw al axa lsax clo abjy osb apdz bdob pzzx zahk c bznj gar osb xkuo zahk zg uce zg clo e apdz gar xq dbun buwcl ili bznj clo osb dc dbun ywz";
        String rnote = "buwcl qr axa ypy zahk nvxtb dp hfki ii uce dc zg dbun ypy ty cqjq zg kty bznj zg zahk dp c al ugj ywz qcub ywz wdyw hfki gar e axa dp qr kty bznj clo ty vucgg qcub al vkrzl qcub j awfvf soqku lsax bdob nvxtb";
        String[]magazine = mag.split(" ");
        String[]note = rnote.split(" ");
        checkMagazine(Arrays.asList(magazine), Arrays.asList(note));
    }

    /**
     * Method print the answer that user can write the ransom note by using magazine.
     * @param magazine words in magazine
     * @param note words in ransom note
     *
     * First, create a HashMap to store the words in magazine.
     * Then, put all words in magazine list to magazine hashmap. hash map used to determine repetitions of each word.
     *       String is a word in hashmap, and Integer store the value that
     *       how many times these words repeated in the magazine.
     *
     * After that, start to check words in note exists in magazine.
     *       If the word exist in HasMap check that value is bigger than or equal to 1,
     *             if it is bigger or equal to 1 then decrease repeat number by 1 and check the next word.
     *       If word exist but value is smaller than 1 or not exist then print "No" and return
     * If All the words checked in the magazine and loop never broke bc of the conditions above, then
     *    print "Yes"
     *
     */
    public static void checkMagazine(List<String> magazine, List<String> note) {
        HashMap<String, Integer>magMap = new HashMap<>();
        for(String word : magazine){
            if(magMap.containsKey(word)){
                int c = magMap.get(word);
                magMap.put(word,(c + 1));
            }else {
                magMap.put(word, 1);
            }
        }

        for(String word : note){
            if(magMap.containsKey(word)){
                if(magMap.get(word) >= 1){
                    magMap.put(word, (magMap.get(word) - 1));
                }else{
                    System.out.println("No");
                    return;
                }
            }else{
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
