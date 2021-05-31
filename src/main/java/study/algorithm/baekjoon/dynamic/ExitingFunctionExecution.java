package study.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExitingFunctionExecution {

    private static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c);
            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, result));
        }

        System.out.println(sb);
    }
    
    private static int w(int a, int b, int c) {
        if (isInnerRange(a, b, c) && arr[a][b][c] != 0) {
            return arr[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return arr[20][20][20] = w(20, 20, 20);
        } else if (a < b && b < c) {
            return arr[a][b][c] =  w(a, b, c-1) + w(a, b - 1, c - 1) - w(a , b - 1, c);
        }

        return arr[a][b][c] = w(a - 1, b , c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1)
                - w(a - 1, b - 1, c - 1);
    }

    private static boolean isInnerRange(int a, int b, int c) {
        return a >= 0 && b >= 0 && c >= 0 && a <= 20 && b <= 20 && c <= 20;
    }

}
