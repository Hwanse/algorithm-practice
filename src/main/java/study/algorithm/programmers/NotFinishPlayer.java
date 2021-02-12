package study.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 향상된 for문을 사용하기 위해서는 'java.lang.iterab;e' 인터페이스를
 * 구현해야한다. 따라서 아래와 같은 Set은 Collection 을 상속하고 있고
 * 이 Collection 은 iterable 을 구현하고 있기 때문에 사용이 가능하다.
 */
public class NotFinishPlayer {

  public String solution(String[] participant, String[] completion) {
    String answer = null;
    // 풀이 1
    /*
    Map<String, Integer> map = new HashMap<>();

    for (String player : participant) {
      map.put(player, map.getOrDefault(player, 0) + 1);
    }

    for (String finisher : completion) {
      map.put(finisher, map.get(finisher) - 1);
    }

    for (String key : map.keySet()) {
      if (map.get(key) > 0) {
        answer = key;
      }
    }
    */

    // 풀이 2
    Arrays.sort(participant);
    Arrays.sort(completion);

    for (int i = 0; i < completion.length; i++) {
      if(!participant[i].equals(completion[i])) {
        return participant[i];
      }
    }

    return participant[participant.length - 1];
  }

}
