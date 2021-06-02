package study.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Bottom-Up 스타일로 풀이
 * 가장 아래에서 부터 이전 요소들의 최소값을 계속 더하면서 결론을 도출한다.
 */
public class Solution1149 {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] costs = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            costs[i][RED] = Integer.parseInt(tokenizer.nextToken());
            costs[i][GREEN] = Integer.parseInt(tokenizer.nextToken());
            costs[i][BLUE] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int previous = i - 1;
            costs[i][RED] += Math.min(costs[previous][GREEN], costs[previous][BLUE]);
            costs[i][GREEN] += Math.min(costs[previous][RED], costs[previous][BLUE]);
            costs[i][BLUE] += Math.min(costs[previous][RED], costs[previous][GREEN]);
        }

        System.out.println(Math.min(Math.min(costs[n - 1][RED], costs[n - 1][GREEN]), costs[n - 1][BLUE]));
    }

}
