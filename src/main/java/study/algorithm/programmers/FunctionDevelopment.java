package study.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 1. SortedMap
 * : Map의 key값을 기준으로 정렬된 Map인 인터페이스다
 *
 * 1-1. 조건
 * SortedMap을 구현하는 모든 class들은 4개의 생성자를 제공 및 준수해야한다.
 * 1) 기본 정렬을 하는 인자값이 없는 생성자
 * 2) Comparator 인스턴스를 인자로 받는 생성자
 * 3) Map 인스턴스를 인자로 받는 생성자
 * 4) SortedMap 인스턴스를 인자로 받고 그 인스턴스와 같은 Comparator를 사용하는 생성자
 *
 * => 위 조건들을 만족하는 잘 구현된 class는 TreeMap 이다. 따라서 TreeMap 생성자를
 *    통해서 SortedMap을 구현화가 가능 (TreeMap은 SoredMap을 상속받은 NavigableMap
 *    을 구현화한 것이다.)
 *
 * 1-2. 주의점
 * 1) SortedMap의 subMap 메소드는 fromKey를 포함하고 toKey를 포함하지 않는다.
 * 2) TreeMap은 동기화 처리가 되어 있찌 않아서 Multi-Tread 환경에서 사용하는 것은
 *    위험성이 있어 동시성에 대한 처리가 불가하다. 만일 사용해야하는 경우가 있다면
 *    Collections.synchronizedMap 메서드를 통해 동기화된 TreeMap을 얻는 것이 가능
 * 3) TreeMap의 containsKey, get, put, remove 메소드의 시간복잡도는 log n을 보장
 */
public class FunctionDevelopment {

  public int[] solution(int[] progresses, int[] speeds) {
    // 기능 개발은 앞선 작업의 개발이 끝나야 뒷 작업들의 배포가 가능함으로 Queue 사용
    Queue<Integer> queue = new LinkedList<>();
    // 기능별 작업 마무리 결과를 저장할 자료로 Map 사용, key : 일자 / value : 배포 건수
    SortedMap<Integer, Integer> result = new TreeMap<>();

    for (int i = 0; i < progresses.length; i++) {
      queue.add(progresses[i]);
    }

    int day = 1;        // 작업 소요 일자
    int workOrder = 0;  // 작업 순서
    while (!queue.isEmpty()) {

      int progress = queue.peek();
      /**
       * 작업 상황이 100% 이상이면 작업 큐에서 제거, 큐의 선행 작업이 끝난 뒤
       * 그 이후 작업이 앞선 작업의 day 만큼 처리했을 때 동일하게 끝나는 경우도
       * 있으므로, continue를 사용하여 바로 뒷 작업의 진행형황을 체크.
       * 뒷 작업이 마무리가 안됐으면 day 값을 증가하여 반복 처리
       */
      if (progress + (speeds[workOrder] * day) >= 100) {
        queue.poll();
        workOrder++;
        result.put(day, result.getOrDefault(day, 0) + 1);
        continue;
      }

      day++;
    }

    int[] answer = new int[result.size()];
    int index = 0;

    for (int key : result.keySet()) {
      answer[index++] = result.get(key);
    }

    return answer;
  }

}