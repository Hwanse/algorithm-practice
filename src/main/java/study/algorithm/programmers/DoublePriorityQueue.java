package study.algorithm.programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (String operation : operations) {
            String[] command  = operation.split(" ");

            Operation type = Operation.getType(command[0]);

            if (Operation.INPUT == type) {
                queue.offer(Integer.parseInt(command[1]));
            }

            if (!queue.isEmpty() && Operation.DELETE == type) {
                if ("-1".equals(command[1])) {
                    queue.poll();
                } else {
                    int max = Collections.max(queue);
                    queue.remove(max);
                }
            }
        }

        if (queue.isEmpty()) {
            return new int[]{0,0};
        }

        int max = Collections.max(queue);
        int min = queue.peek();
        return new int[] {max, min};
    }

}

enum Operation {
    INPUT("I"), DELETE("D");

    private String value;
    private static Map<String, Operation> map = new HashMap<>();

    Operation(String value) {
        this.value = value;
    }

    public static Operation getType(String value) {
        return map.get(value);
    }

    static {
        for (Operation op : values()) {
            map.put(op.value, op);
        }
    }
}