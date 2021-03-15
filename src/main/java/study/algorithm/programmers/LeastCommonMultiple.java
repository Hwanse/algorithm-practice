package study.algorithm.programmers;

import java.util.Arrays;

public class LeastCommonMultiple {

    public int solution(int[] arr) {
        // arr의 최대 값을 먼저 기준으로 시작해서 결과를 도출
        int max = Arrays.stream(arr).max().orElseThrow();
        int answer = max;

        int count = 1;
        boolean stopFlag = false;

        while (!stopFlag) {
            answer = max * count++;

            for (int number : arr) {
                if (answer % number != 0) {
                    stopFlag = false;
                    break;
                }

                stopFlag = true;
            }
        }

        return answer;
    }

}
