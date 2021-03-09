package study.algorithm.programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapTest {

    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int number : scoville) {
            maxHeap.offer(number);
        }

        while (maxHeap.size() > 1 && maxHeap.peek() < K) {
            int mix = maxHeap.poll() + (maxHeap.poll() * 2);
            maxHeap.offer(mix);
            count++;
        }

        return maxHeap.peek() < K ? -1 : count;
    }

}
