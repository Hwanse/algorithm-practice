package study.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NAndM2 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[] arr = new int[m];

        dfs(arr, n,0, m, 1);

        System.out.println(sb.toString());
    }

    private static void dfs(int[] arr, int n, int currentDepth, int m, int start) {
        if (currentDepth == m) {
            for (int number : arr) {
                sb.append(number + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[currentDepth] = i;
            dfs(arr, n,currentDepth + 1, m, i + 1);
        }
    }

}
