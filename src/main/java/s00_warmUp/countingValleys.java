package s00_warmUp;

/**
 * Easy if usage, the problem is how valleys defined.
 * In the problem statement it is said that valleys will count after
 * sea level, means altitude equals to zero
 */
public class countingValleys {
    public static void main(String[] args) {
        String path = "UDDDUDUU";
        System.out.println(countingValleys(path.length(), path));
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here

        int altitude = 0;
        int valley = 0;
        for(int i = 0; i < steps; i++){
            if(path.charAt(i) == 'U'){
                if (altitude == -1) {
                    valley++;
                }
                altitude++;
            }else{
                altitude--;
            }
        }

        return valley;
    }

}
