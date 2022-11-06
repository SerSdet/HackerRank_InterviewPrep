package s08_dynamicProgramming;

public class Abbreviation {
    public static void main(String[] args) {
        String a = "daBcd";
        String b = "ABC";
        System.out.println(abbreviation(a,b));
    }

    /**
     * Method will return "YES" if abbreviation can be made from string 'a' as string 'b' by deleting or making
     * uppercase lowercase characters in 'a'.
     * @param a string which will turn into abbreviation
     * @param b target abbreviation
     * @return "YES" or "NO"
     *
     * Detail explanation of the algorithm also noted before the lines
     * Summary;
     * First, If string A is shorter than case directly be false,
     * Then, create a boolean array to store our results, each dimension must be one more than size of the string,
     *  it will all false as default , each table cell will be true
     *  if substring of 'a' can be make abbreviation of substring of 'b', if not will be false.
     *   for example; for string a = "daBcd", b = "ABC" cell [2][2] represent isValid("ba","AB")
     *    so isValid[5][3] represents isValid("daBcd","ABC"), which is our final answer.
     *
     *  Initially assign isValid[0][0] means two string is null it must be true
     *
     * (NOTE:String 'a' and 'b' considered as a char array for easy representation)
     * After that,start to fill the first column [i-1, 0], first column keep the result of isValid function result
     *    if a has some value but b is null. (So if a is lowercase it can be deleted and become equal to b
     *    but if a has uppercase then it can not be deleted and become false.
     *
     * Then, fill the first row as for null a and value in b always false, similar to initial condition it always false,
     *  since default value for the boolean array is false we don't do additional step for [0, j]s
     *
     *  After these two steps, first column (where i = 0) and first row  (where j = 0) has filled,
     *
     *  After that, we start to evaluate each cell of the table, by using two nested loops i for 'a' and j for 'b'
     *  in each step characters in a[i-1], j[j-1] will be compared for isValid[i][j] (remember extra column and row)
     *
     *  There are 4 different possibility when we check the a[i-1] and b[j-1]
     *
     *      1- Characters a[i] is equal to b[j] : then the value must be same as upper left
     *         (without these two characters isValid(baB,AB) = isValid(ba,A))
     *      2- If character a[i] changed to uppercase, it is equal to b[j] :then, the value is upper left, or upper cell
     *         ( isValid(ba,A) = isValid(b, ) OR isValid(b,A)
     *      3- If character a[i] is uppercase and not equal to b[j] :then isValid will be false
     *      4- If character a[i] is lowercase but not equal to b[j] (no condition bc this is the last option)
     *         then isValid equal to upper cell, isValid(ba,AB) = isValid(b,AB)
     *
     *   After nested loop finished, if last cell (isValid[a.length()][b.length()] is true, return "YES" otherwise "NO"
     */

    public static String abbreviation(String a, String b) {
        if(a.length()<b.length()){
            return "NO";
        }
        //Create a boolean array to store our results, each dimension must be one more than size of the string,
        // it will all false as default

        //each table cell will be true if substring of 'a' can be make abbreviation of substring of 'b',
        //if not will be false.
        //for example; for string a = "daBcd", b = "ABC" cell [2][2] represent isValid("ba","AB")
        // so isValid[5][3] represents isValid("daBcd","ABC"), which is our final answer.
        boolean[][]isValid = new boolean[a.length()+1][b.length()+1];
        isValid[0][0] = true;
        //start to fill the first column [i-1, 0], first column keep the result of isValid function result
        // if a has some value but b is null. (So if a is lowercase it can be deleted and become equal to b
        //but if a has uppercase then it can not be deleted and become false.
        for (int i = 1; i <= a.length(); i++){
            char tmpChar = a.charAt(i-1);
            isValid[i][0] = (!Character.isUpperCase(tmpChar));
        }
        //for null a and value in b always false, similar to initial condition it always false,
        //since default value for the boolean array is false we don't do additional step for [0, j]s
        //after these steps, first column (where i = 0) and first row  (where j = 0) has filled,
        //Stars from isValid[1][1] (Means first letters of each string) check all the cells of the table,
        //final result is last cell ([a.length][b.length])of the table
        //There are 4 different possibility when we check the a[i-1] and b[j-1]
        //Algorithm will check all these scenarios in the table
        for (int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                // 1- characters a[i] is equal to b[j] : then the value must be same as upper left
                // (without these two characters isValid(baB,AB) = isValid(ba,A)
                if(a.charAt(i-1) == b.charAt(j-1)){
                    isValid[i][j] = isValid[i-1][j-1];
                //2-if character a[i] changed to uppercase, it is equal to b[j] :
                //then, the value is upper left, or upper cell
                //( isValid(ba,A) = isValid(b, ) OR isValid(b,A)
                }else if(Character.toUpperCase(a.charAt(i-1)) == b.charAt(j-1)){
                    isValid[i][j] = isValid[i-1][j-1] || isValid[i-1][j];
                //3-if character a[i] is uppercase and not equal to b[j]
                //then isValid will be false
                }else if (Character.isUpperCase(a.charAt(i-1))){
                    isValid[i][j] = false;
                //4- if character a[i] is lowercase but not equal to b[j] (no condition bc this is the last option)
                //then isValid equal to upper cell, isValid(ba,AB) = isValid(b,AB)
                }else{
                    isValid[i][j] = isValid[i-1][j];
                }
            }
        }
        return isValid[a.length()][b.length()] ? "YES" : "NO";
    }
}
