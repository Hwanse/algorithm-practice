package study.algorithm.programmers;

import java.util.Arrays;

public class WordConversion {

  private boolean[] visited;

  public int solution(String begin, String target, String[] words) {
    visited = new boolean[words.length];

    if (!Arrays.asList(words).contains(target))
      return 0;

    return findMinConvertCount(words, begin, target, 0, words.length);
  }

  public int findMinConvertCount(String[] words, String standardWord, String target, int count, int minCount) {
    if (standardWord.equals(target)) {
      return count;
    }

    for (int i = 0; i < words.length; i++) {
      if (!visited[i] && isConvertable(standardWord, words[i])) {
        visited[i] = true;
        int tmpCount = findMinConvertCount(words, words[i], target,count + 1, minCount);
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
