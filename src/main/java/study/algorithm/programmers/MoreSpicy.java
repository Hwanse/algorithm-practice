package study.algorithm.programmers;

import java.util.PriorityQueue;

public class MoreSpicy {

  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int data : scoville) {
      minHeap.offer(data);
    }

    while (minHeap.size() > 1 && minHeap.peek() < K) {
      int mix = minHeap.poll() + (minHeap.poll() * 2);
      minHeap.offer(mix);
      answer++;
    }

    return minHeap.peek() < K ? -1 : answer;
  }

}
