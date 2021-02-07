package study.algorithm.programmers;

import java.util.Arrays;

public class KNumber {

  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for (int x = 0; x < commands.length; x++) {
      int[] command = commands[x];
      // 배열 자르기
      int[] slicedArr = slice(array, command);
      // 정렬
      Arrays.sort(slicedArr);
      // 명령어로 반환된 결과 값
      answer[x] = slicedArr[command[2] - 1];
    }

    return answer;
  }

  private int[] slice(int[] numbers, int[] command) {
    int from = command[0] - 1;
    int to = command[1];
    int[] slicedArr = new int[to-from];
    int idx = 0;

    for (int i = from; i < to; i++) {
      slicedArr[idx++] = (numbers[i]);
    }

    return slicedArr;
  }

}
