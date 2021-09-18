package study.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution1018 {

    private static final String BLACK = "B";
    private static final String WHITE = "W";
    private static Map<Integer, String> colors = new HashMap<>();

    private static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int m = Integer.parseInt(size[0]);
        int n = Integer.parseInt(size[1]);
        board = new String[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; n++) {
                board[i][j] = String.valueOf(input.charAt(j));
            }
        }

        String start = board[0][0];


    }

}
