package study.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NAndM1 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        boolean[] visited = new boolean[n];
        int[] arr = new int[m];

        dfs(visited, arr, 0, m);

        System.out.println(sb.toString());
    }

    private static void dfs(boolean[] visited, int[] arr, int currentDepth, int m) {
        if (currentDepth == m) {
            for (int number : arr) {
                sb.append(number + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[currentDepth] = i + 1;
                dfs(visited, arr, currentDepth + 1, m);
                visited[i] = false;
            }
        }
    }

}
