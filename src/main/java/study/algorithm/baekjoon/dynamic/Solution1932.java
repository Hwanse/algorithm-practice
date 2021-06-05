package study.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1932 {

    private static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            triangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                triangle[i][j] = value;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }

        System.out.println(triangle[0][0]);
    }

}
