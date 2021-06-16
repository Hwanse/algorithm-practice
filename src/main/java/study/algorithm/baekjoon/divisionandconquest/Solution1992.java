package study.algorithm.baekjoon.divisionandconquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1992 {

    private static int[][] matrix;
    private static final int WHITE = 0;
    private static final int BLACK = 1;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.charAt(j) - '0';
            }
        }

        partition(0, 0, n);
        System.out.println(sb);

    }

    private static void partition(int x, int y, int size) {
        if (checkColor(x, y, size)) {
            if (matrix[x][y] == WHITE) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            return;
        }

        int dividedSize = size / 2;

        sb.append("(");
        partition(x, y, dividedSize);   // 북서
        partition(x, y + dividedSize, dividedSize); // 북동
        partition(x + dividedSize, y, dividedSize); // 남서
        partition(x + dividedSize, y + dividedSize, dividedSize); // 남동
        sb.append(")");
    }

    private static boolean checkColor(int x, int y, int size) {
        int standardColor = matrix[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (matrix[i][j] != standardColor) {
                    return false;
                }
            }
        }

        return true;
    }

}
