package s02_search;

import java.math.BigInteger;

public class MakingCandies {
    public static void main(String[] args) {
        long m  = 3;
        long w = 1;
        long p = 1;
        long n = 12;

        System.out.println(minimumPasses(m,w,p,n));

    }

    /**
     * This function is designed to calculate minimum required pass to produce target amount of candy
     *
     * @param m number of machines initially have
     * @param w number of workers initially have
     * @param p cost of buy machine or hire a worker (as candy)
     * @param n number of candies to produce
     * @return minimum number of passes (cycles) to produce target amount(n) of candy
     *
     * First calculate the first days production and check if 'n' requires multiple day production.
     * Then go into while loop while production is smaller than n, in this loop,
     *       - first, calculate remaining pass as if user don't buy a machine or hire a worker.
     *       - then, update minimum pass with smaller value of
     *                minimum pass value or current pass and remaining pass addition.
     *       - if remaining pass equal to 1 than break and reurn the current minPass,
     *       - Check that if we can buy or hire with current production,
     *             - if production is smaller that cost of hire/buy than calculate extra pass required to buy/hire
     *                and update production value with this extra pass production
     *             - before or buy/hire check production is higher from n value or not
     *                if production is higher or equal to target value than update min Pass value
     *                  with smaller value of minpass or current pass.
     *             - we spend p in each time, so decrease production by p and
     *                        decide to increase w or m by using if in next step.
     *              - to decide buy or hire check the m and w, if they are equal multiplication is bigger so
     *                     if m small or equal to w than increase m one
     *                      otherwise increase w one.
     */

    public static long minimumPasses(long m, long w, long p, long n) {
        if(BigInteger.valueOf(m).multiply(BigInteger.valueOf(w)).compareTo(BigInteger.valueOf(n)) > 0 ){
            return 1;
        }
        long minPass = Long.MAX_VALUE;
        long currentPass = 0;
        long production = 0;

        while(production < n){
            long remainingPass = divideToUp((n-production),(m * w));
            minPass = Math.min(minPass, currentPass + remainingPass);

            if(remainingPass == 1){
                break;
            }

            if(production < p) {
                long extraPass = divideToUp((p - production), (m * w));
                currentPass += extraPass;
                production += extraPass * (m * w);
            }

            if(production >= n ){
                minPass = Math.min(minPass, currentPass);
            }

            production -= p;
            if(m <= w){
                m++;
            }else{
                w++;
            }
        }
        return minPass;
    }

    /**
     * This sub program divide x to y and return the number but if remainder not equals to 0,
     * increase result (quotient) one.
     * @param x dividend
     * @param y Division
     * @return
     */
    private static long divideToUp(long x, long y) {
        return (x / y + (x % y ==0 ? 0 : 1));
    }
}
