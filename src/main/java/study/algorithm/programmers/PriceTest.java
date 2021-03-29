package study.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PriceTest {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int value : prices) {
            queue.offer(value);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int price = queue.poll();
            int downSecond = prices.length - (index + 1);

            for (int i = index; i < prices.length; i++) {
                if (price > prices[i]) {
                    downSecond = i - index;
                    break;
                }
            }

            answer[index++] = downSecond;
        }

        return answer;
    }

}
