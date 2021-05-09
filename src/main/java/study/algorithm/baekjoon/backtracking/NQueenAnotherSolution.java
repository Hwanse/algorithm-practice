package study.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueenAnotherSolution {

    private static int answer = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 배열의 index 주소를 '행'으로, 해당 배열 index 안에 저장된 값을 '열'로 취급한다
        arr = new int[n];

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int row) {
        if (row == arr.length) {
            answer++;
            return;
        }
        for (int column = 0; column < arr.length; column++) {
            arr[row] = column;
            if (isPossible(row)) {
                dfs(row + 1);
            }
        }
    }

    private static boolean isPossible(int currentRow) {
        // 아직 퀸을 놓지 않은 상태이므로 다음 전체 Row를 대상으로 값을 검사할 필요가 없으며,
        // 초기 값들로 인해 조건을 통과하지 못한다.
        for (int row = 0; row < currentRow; row++) {
            // 같은 열에 퀸이 있는지
            if (row != currentRow && arr[currentRow] == arr[row]) {
                return false;
            }
            // 대각선 라인 체크
            if (Math.abs(row - currentRow) == Math.abs(arr[row] - arr[currentRow])) {
                return false;
            }
        }

        return true;
    }

}
