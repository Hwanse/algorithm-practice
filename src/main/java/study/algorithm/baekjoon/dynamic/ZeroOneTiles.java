package study.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneTiles {

    private static int[] arr;
    private static final int MAX_SIZE = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[MAX_SIZE + 1];
        arr[1] = 1;
        arr[2] = 2;

        if (n <= 2) {
            System.out.println(arr[n]);
            return;
        }

        System.out.println(tiles(n));
    }

    private static int tiles(int n) {
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
        }

        return arr[n];
    }

}
