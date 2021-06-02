package study.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaveGroupSequence {

    private static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputs = new ArrayList<>();

        // 첫 3개의 정삼각형을 초기화
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            inputs.add(Integer.parseInt(br.readLine()));
        }

        int max = Collections.max(inputs).intValue();
        p(max);

        for (int n : inputs) {
            System.out.println(arr[n]);
        }

    }

    private static long p(int n) {
        if (n <= 3) {
            return arr[n];
        }

        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }

        return arr[n];
    }

}
