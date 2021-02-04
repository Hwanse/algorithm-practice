package study.algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

class EndingWords {

  public int[] solution(int n, String[] words) {
    Rule rule = new Rule();

    // 첫 단어는 규칙을 체크할 필요 없으므로 리스트에 추가
    rule.addWord(words[0]);

    for (int i = 1; i < words.length; i++) {
      int playerIndex = i % n;
      int playerNo = playerIndex + 1;
      String currentWord = words[i];

      if (!rule.checkWordRule(words[i - 1], currentWord)) {
        return new int[]{playerNo, (i / n) + 1};
      }

      rule.addWord(currentWord);
    }

    return new int[]{0, 0};
  }

}

class Rule {

  List<String> beforeWords = new ArrayList<>();

  public boolean checkWordRule(String beforeWord, String currentWord) {
    if (beforeWord.charAt(beforeWord.length() - 1) != currentWord.charAt(0)) {
      return false;
    } else if (beforeWords.contains(currentWord)) {
      return false;
    }
    return true;
  }

  public void addWord(String word) {
    beforeWords.add(word);
  }

}