package org.test;

import java.util.Arrays;

/**
 * for question:
 * https://www.oschina.net/question/3856487_2285888
 * Created with IntelliJ IDEA.
 *
 * @author: Foy Lian
 * Date: 8/28/2018
 * Time: 7:35 AM
 */
public class Sum {
    public static void main(String[] args) {
        int[] s = {900, 105, 99, 80, 50, 30, 20, 15, 5};
        int len = 1000;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = len; j >= 0; j--) {
                if (dp[j] >= 0 && j + s[i] <= len && dp[j + s[i]] == -1) {
                    dp[j + s[i]] = i;
                }
            }
        }
        int where = 0;
        for (int k = len; k >= 0; k--) {
            if (dp[k] > 0) {
                where = k;
                break;
            }
        }
        while (true) {
            if (where == 0) {
                break;
            }
            System.out.print(s[dp[where]] + " ");
            where = where - s[dp[where]];
        }
    }

}
