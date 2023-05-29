package s08_dynamicProgramming;


public class DeciBinaryNumbers {
    public static void main(String[] args) {
        System.out.println(decibinaryNumbers(19));
    }

    public static Long count[] = new Long[300000];
    public static Long sum[] = new Long[300000];
    public static int maxRaw[] = new int[300000];
    public static Long count2[][] = new Long[19][300000];

    public static long decibinaryNumbers(long x) {
        // Write your code here

        int a = 0;
        int b = count.length - 1;
        int c = 0;
        int dec = 0;
        while ((b - a) > 1) {
            c = (a + b) / 2;
            if (x > sum[c]) {
                a = c;
            } else {
                b = c;
            }
        }
        if (x > sum[a]) {
            dec = b;
        } else {
            dec = a;
        }

        Long res = 0l;
        if (dec > 0) {
            Long idx = x - sum[dec - 1];
            int val = dec;

            int raw = 1;
            int start = Math.min(maxRaw[val] + 1, count2.length);

            for (int i = 1; i < start; i++) {
                raw *= 2;
            }


            for (int i = start - 1; i > 0; i--) {
                Long sum = 0l;
                for (int j = 0; (j < 10) && (val >= 0); j++) {
                    sum += count2[i - 1][val];
                    if (sum >= idx) {
                        idx -= (sum - count2[i - 1][val]);
                        res = res * 10 + j;
                        break;
                    }
                    val -= raw;
                }

                raw /= 2;
            }
            res = res * 10 + val;
        }
        return res;
    }

    public static void initialize() {
        int n = count2.length;
        int m = count2[0].length;
        for (int i = 0; i < m; i++) {
            count2[0][i] = (i < 10) ? 1l : 0l;
        }
        int raw = 1;
        int val = 0;
        for (int i = 1; i < n; i++) {
            System.arraycopy(count2[i - 1], 0, count2[i], 0, m);
            raw *= 2;
            for (int j = 0; j < m; j++) {
                val = j - raw;
                if (val >= 0) {
                    for (int k = 1; k < 10; k++) {
                        count2[i][j] += count2[i - 1][val];
                        val -= raw;
                        if (val < 0) {
                            break;
                        }
                    }
                }

            }
        }

        for (int i = 0; i < m; i++) {
            count[i] = count2[n - 1][i];
            sum[i] = count[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
        }

        int r = 0;
        int v = 2;
        for (int i = 0; i < m; i++) {
            if (i >= v) {
                r++;
                v *= 2;
            }
            maxRaw[i] = r;
        }

    }

}
