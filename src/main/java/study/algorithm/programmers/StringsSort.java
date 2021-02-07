package study.algorithm.programmers;

import java.util.Arrays;

/**
 * comparator
 * 기본적으로 두 방식 모두 오버라이딩을 안하면 '오름차순' 정렬을 수행
 * '양수'일 경우에는 두 변수의 자리가 바뀌고 '0' 또는 '음수'일 경우에는 제자리에 유지
 * 정렬 조건 (오름 차순)
 * 1. 전위 변수 < 후위 변수  -> -1 을 리턴
 * 2. 전위 변수 == 후위 변수 -> 0을 리턴
 * 3. 전위 변수 > 후위 변수 -> 1을 리턴
 *
 * 정렬 조건 (오름 차순)
 * 1. 전위 변수 < 후위 변수 -> 1을 리턴
 * 2. 전위 변수 == 후위 변수 -> 0을 리턴
 * 3. 전위 변수 > 후위 변수 -> -1을 리턴
 */
public class StringsSort {

  /**
   * 이 문제에서는 n 인자의 index 기준으로 오를참순 정렬을 수행하는데
   * 단, 해당 문자의 값이 동일할 경우에는 해당 단어의 사전의 순서를 기준으로 정렬
   *   => 즉, 문자열 그대로 다시 정렬을 해주어야 하는것이다.
   * 이 문제는 특수한 응용 조건때문에 low 레벨로 정렬을 구현해야 하는 것처럼 보였으나
   * sort 함수를 유연하게 사용해주는 것이 편한 방식으로 보임
   * @param strings 정렬할 배열
   * @param n 정렬 기준이 될 문자의 index
   * @return 정렬 결과
   */
  public String[] solution(String[] strings, int n) {
    String[] answer = strings;

    Arrays.sort(answer, (str1, str2) -> {
      if (str1.charAt(n) < str2.charAt(n)) {
        return -1;
      } else if (str1.charAt(n) == str2.charAt(n)) {
        return str1.compareTo(str2);
      } else {
        return 1;
      }
    });

    return answer;
  }

}
