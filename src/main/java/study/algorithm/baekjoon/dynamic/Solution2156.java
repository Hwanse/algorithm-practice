package study.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2156 {

    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        if (n == 2) {
            dp[1] = arr[0] + arr[1];
        } else if (n >= 3) {
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(Math.max(arr[0] + arr[1], arr[1] + arr[2]), arr[0] + arr[2]);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));

        }

        System.out.println(dp[n - 1]);
    }

}
