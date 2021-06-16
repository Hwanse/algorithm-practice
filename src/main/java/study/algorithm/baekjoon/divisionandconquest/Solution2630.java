package study.algorithm.baekjoon.divisionandconquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 조건
 * 1. 각 행,열의 시작점에서 현재 파티션에 대하여 모두 같은 색상인지 체크
 * 2. 색상이 같다면 해당 색상의 개수를 증가시키고 함수를 종료
 * 3. 색상이 같지 않으면, 다시 사각형을 쪼개어 위 과정을 반복한다.
 */
public class Solution2630 {

    private static int[][] matrix;
    private static int whiteCount = 0;
    private static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        partition(0, 0, n);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void partition(int x, int y, int size) {
        if (colorCheck(x, y, size)) {
            if (matrix[x][y] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int dividedSize = size / 2;

        partition(x, y, dividedSize);   // 1사분면
        partition(x, y + dividedSize, dividedSize); // 2사분면
        partition(x + dividedSize, y, dividedSize); // 3사분면
        partition(x + dividedSize, y + dividedSize, dividedSize);   // 4사분면
    }

    private static boolean colorCheck(int x, int y, int size) {
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
