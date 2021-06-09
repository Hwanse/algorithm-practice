package study.algorithm.baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.contains("push")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                queue.offer(number);
            } else if (input.contains("pop")) {
                if (queue.isEmpty()) {
                    append(sb, -1);
                } else {
                    append(sb, queue.poll());
                }
            } else if (input.contains("size")) {
                append(sb, queue.size());
            } else if (input.contains("empty")) {
                if (queue.isEmpty()) {
                    append(sb, 1);
                } else {
                    append(sb, 0);
                }
            } else if (input.contains("front")) {
                if (queue.isEmpty()) {
                    append(sb, -1);
                } else {
                    append(sb, queue.peek());
                }
            } else {
                if (queue.isEmpty()) {
                    append(sb, -1);
                } else {
                    List<Integer> list = queue.stream().collect(Collectors.toList());
                    append(sb, list.get(list.size() - 1));
                }
            }

        }

        System.out.println(sb);
    }

    private static void append(StringBuilder sb, long value) {
        sb.append(value + "\n");
    }

}
