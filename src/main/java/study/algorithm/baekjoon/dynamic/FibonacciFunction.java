package study.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciFunction {

    private static int[][] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            counts = new int[n + 1][2];

            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    counts[0][0] = 1;
                    continue;
                } else if (j == 1) {
                    counts[1][1] = 1;
                    continue;
                }

                counts[j][0] = counts[j - 1][0] + counts[j - 2][0];
                counts[j][1] = counts[j - 1][1] + counts[j - 2][1];
            }

            answer.append(counts[n][0] + " " + counts[n][1] + "\n");
        }

        System.out.println(answer);
    }

}
