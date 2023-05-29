package s08_dynamicProgramming;

import java.util.Scanner;

public class DemoJava {
    public static int binarySearch(long[] sums, long x) {
        int left = 0;
        int right = sums.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (sums[m] == x) {
                return m;
            } else if (sums[m] > x) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int P = 19;
        int N = 1 << P;
        long[][] dp = new long[P + 1][N + 1];
        long[] sums = new long[N + 1];
        sums[0] = 1;

        for (int p = 0; p <= P; p++) {
            dp[p][0] = 1;
            int item = 1 << p;
            for (int k = 1; k < 10; k++) {
                if (item * k <= N) {
                    dp[p][item * k] += 1;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (dp[p][i] > 0) {
                    for (int p2 = p + 1; p2 <= P; p2++) {
                        int item2 = 1 << p2;
                        for (int k = 1; k < 10; k++) {
                            if (i + (item2 * k) <= N) {
                                dp[p2][i + (item2 * k)] += dp[p][i];
                            }
                        }
                    }
                    sums[i] += dp[p][i];
                }

                if (p > 0) {
                    dp[p][i] += dp[p - 1][i];
                }
            }
//            System.out.println(Arrays.toString(dp[p]));
        }

        long[] prefixSums = new long[N + 1];
        prefixSums[0] = 1;
        for (int i = 1; i <= N; i++) {
            prefixSums[i] = prefixSums[i - 1] + sums[i];
        }

//        System.out.println(Arrays.toString(sums));
//        System.out.println(Arrays.toString(prefixSums));

        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            if (x == 1) {
                System.out.println(0);
                continue;
            }
            int decimalValue = binarySearch(prefixSums, x);
            long ordinal = x - prefixSums[decimalValue - 1];

            String result = decode(decimalValue, ordinal, dp);
            System.out.println(result);
        }
    }

    private static String decode(int decimal, long ordinal, long[][] dp) {
        StringBuilder sb = new StringBuilder();
        int lastPower = -1;
        while (decimal >= 0) {
            int highestPower = 0;
            long remainder = ordinal;
            while (dp[highestPower][decimal] < ordinal) {
                remainder = ordinal - dp[highestPower][decimal];
                highestPower++;
            }

            if (lastPower != -1 && highestPower != lastPower - 1) {
                for (int z = 0; z < lastPower - highestPower - 1; z++) {
                    sb.append('0');
                }
            }
            lastPower = highestPower;

            if (highestPower == 0) {
                sb.append((char)('0' + decimal));
                break;
            }

            int power = 1 << highestPower;
            long sum = 0;
            int k;
            for (k = 1; k < 10; k++) {
                if (sum + dp[highestPower - 1][decimal - (k * power)] >= remainder) {
                    sb.append((char)('0' + k));
                    decimal -= k * power;
                    ordinal = remainder - sum;
                    break;
                } else {
                    sum += dp[highestPower - 1][decimal - (k * power)];
                }
            }
        }
        return sb.toString();
    }
}
