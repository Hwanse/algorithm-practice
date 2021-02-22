package study.algorithm.programmers;

import java.util.Arrays;

public class WordConversion {

  public int solution(String begin, String target, String[] words) {
    if (!Arrays.asList(words).contains(target))
      return 0;

    return findMinConvertCount(words, new boolean[words.length], begin, target, 0, words.length);
  }

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
