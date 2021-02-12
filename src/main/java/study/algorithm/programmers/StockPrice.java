package study.algorithm.programmers;

import java.util.Stack;

public class StockPrice {

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];

    // 풀이 1
    for (int x = 0; x < prices.length; x++) {
      int secound = 0;

      for (int y = x + 1; y < prices.length; y++) {
        secound++;
        if (prices[x] > prices[y]) {
          break;
        }
      }

      answer[x] = secound;
    }

    return answer;
  }

}
