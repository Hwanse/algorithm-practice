package study.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

  public int solution(String[][] clothes) {
    int answer = 1;
    Map<String, Integer> category = new HashMap<>();

    for (String[] clothe : clothes) {
      category.put(clothe[1], category.getOrDefault(clothe[1], 0) + 1);
    }

    for (int count : category.values()) {
      answer *= (count + 1);
    }

    return answer - 1;
  }

}
