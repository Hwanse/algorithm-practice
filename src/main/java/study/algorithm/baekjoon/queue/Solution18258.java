package study.algorithm.baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int last = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    int number = Integer.parseInt(input[1]);
                    queue.offer(number);
                    // 큐는 FIFO이기 때문에 push 연산마다 맨 마지막 요소미으로 변수로 저장
                    last = number;
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        append(sb, -1);
                    } else {
                        append(sb, queue.poll());
                    }
                    break;
                case "size":
                    append(sb, queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        append(sb, 1);
                    } else {
                        append(sb, 0);
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        append(sb, -1);
                    } else {
                        append(sb, queue.peek());
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        append(sb, -1);
                    } else {
                        append(sb, last);
                    }
                    break;
                default:
                    break;
            }

        }

        System.out.println(sb);
    }

    private static void append(StringBuilder sb, long value) {
        sb.append(value + "\n");
    }

}
