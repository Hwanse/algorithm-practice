package study.algorithm.programmers;

import java.util.Arrays;
import java.util.Stack;

public class WordConversion {

  public int solution(String begin, String target, String[] words) {
    if (!Arrays.asList(words).contains(target))
      return 0;

    // 스택을 이용한 dfs
    boolean[] visitArr = new boolean[words.length];
    Stack<String> stack = new Stack<>();
    stack.push(begin);

    String standardWord;
    int count = 0;

    while (!stack.isEmpty()) {

      standardWord = stack.pop();

      if (standardWord.equals(target)) {
        break;
      }

      for (int i = 0; i < words.length; i++) {

        if(!visitArr[i] && isConvertable(standardWord, words[i])) {
          visitArr[i] = true;
          stack.push(words[i]);
        }

      }

      count++;
    }

    return count;
//    return findMinConvertCount(words, new boolean[words.length], begin, target, 0, words.length);
  }

  // 재귀를 통해 구현한 dfs
  public int findMinConvertCount(String[] words, boolean[] visited, String standardWord, String target, int count, int minCount) {
    if (standardWord.equals(target)) {
      return count;
    }

    for (int i = 0; i < words.length; i++) {
      if (!visited[i] && isConvertable(standardWord, words[i])) {
        visited[i] = true;
        int tmpCount = findMinConvertCount(words, visited, words[i], target,count + 1, minCount);
        visited[i] = false;

        minCount = Math.min(minCount, tmpCount);
      }
    }

    return minCount;
  }

  public boolean isConvertable(String before, String after) {
    int count = 0;
    for (int i = 0; i < before.length(); i++) {
      if (before.charAt(i) != after.charAt(i))
        count++;
    }
    return count == 1;
  }

}
