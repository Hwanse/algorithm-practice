package study.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    private static int answer = 0;
    private static int[][] chess;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        chess = new int[n][n];

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int x, int queenCount) {
        if (queenCount == chess.length) {
            answer++;
            return;
        }

        for (int i = 0; i < chess[x].length; i++) {
            if (isPossible(x, i)) {
                chess[x][i] = 1;
                dfs(x + 1, queenCount + 1);
                chess[x][i] = 0;
            }
        }
    }

    private static boolean isPossible(int x, int y) {
        // 같은 행에 있는가
        for (int i = 0; i < chess[x].length; i++) {
            if (i != y && chess[x][i] == 1) {
                return false;
            }
        }
        // 같은 열에 있는가
        for (int i = 0; i < chess.length; i++) {
            if (i != x && chess[i][y] == 1) {
                return false;
            }
        }
        // 대각선에 있는가
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                // 행의 차와 열의 차이 값이 같을 때 대각선에 위치한 값임
                if (Math.abs(i - x) == Math.abs(j - y) && chess[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
