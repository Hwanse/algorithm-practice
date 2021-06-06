package study.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] stairs = new int[count];
        int[] dp = new int[count];

        for (int i = 0; i < count; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        init(dp, stairs);

        for (int i = 3; i < count; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[count - 1]);
    }

    private static void init(int[] dp, int[] stairs) {
        dp[0] = stairs[0];

        if (dp.length == 2) {
            dp[1] = Math.max(stairs[0] + stairs[1], stairs[1]);
        } else if (dp.length >= 3){
            dp[1] = Math.max(stairs[0] + stairs[1], stairs[1]);
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        }
    }

}
