package s06_dictionariesAndHashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {
    public static void main(String[] args) {
        Integer[]q1 = new Integer[] {1,3};
        Integer[]q2 = new Integer[] {2,3};
        Integer[]q3 = new Integer[] {3,2};
        Integer[]q4 = new Integer[] {1,4};
        Integer[]q5 = new Integer[] {1,5};
        Integer[]q6 = new Integer[] {1,5};
        Integer[]q7 = new Integer[] {1,4};
        Integer[]q8 = new Integer[] {3,2};
        Integer[]q9 = new Integer[] {2,4};
        Integer[]q10 = new Integer[] {3,2};

        List<List<Integer>>arr = new ArrayList<>();
        arr.add(Arrays.asList(q1));
        arr.add(Arrays.asList(q2));
        arr.add(Arrays.asList(q3));
        arr.add(Arrays.asList(q4));
        arr.add(Arrays.asList(q5));
        arr.add(Arrays.asList(q6));
        arr.add(Arrays.asList(q7));
        arr.add(Arrays.asList(q8));
        arr.add(Arrays.asList(q9));
        arr.add(Arrays.asList(q10));

        System.out.println(freqQuery(arr));
    }

    /**
     * Method execite series oq queries about the one data structure,
     * (1,x) : Add x to the array,
     * (2,y) : Delete one occurence of y from your data structure, if present.
     * (3,z) : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
     * @param queries series of queries as a form of 2d array
     * @return if any message has returned
     *
     * First, Create a HashMap to store data and ArrayList to store messages for 3rd type queries
     * Then, start to go through the 2D array to execute queries
     *      - First create two variable to store query option and query value
     *      - Then, check query type with if else
     *        - If option is 1, then put value to the array
     *        - If option is 2, then decrease frequency by one if it is one then remove the value
     *        - If option is 3, then search array and if found put '1' in msg otherwise put '0'
     *
     *
     */
    private static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> results = new ArrayList<>();
        HashMap<Integer, Integer> arr = new HashMap<>();

        for (int i = 0; i < queries.size(); i++){
            Integer option = queries.get(i).get(0);
            Integer value = queries.get(i).get(1);

            if(option == 1){
                arr.put(value, arr.getOrDefault(value, 0) + 1);
            }else if(option==2){
                if(arr.containsKey(value)){
                    if(arr.containsKey(value)){
                        if(arr.get(value) > 1){
                            arr.put(value, arr.get(value)-1);
                        }else{
                            arr.remove(value);
                        }
                    }
                }
            }else if (option == 3){
                Integer src = 0;
                if(value < queries.size()){
                    for(Map.Entry<Integer, Integer> entry : arr.entrySet()){
                        if(entry.getValue() == value){
                            src = 1;
                            break;
                        }
                    }
                }
                results.add(src);
            }
        }
        return results;
    }
}
