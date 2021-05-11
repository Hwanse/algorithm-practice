package study.algorithm.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Virus {

    private static List<Map<Integer, Integer>> list = new ArrayList<>();
    private static boolean[] visit;
    private static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int lineCount = Integer.parseInt(br.readLine());
        visit = new boolean[computerCount + 1];

        for (int i = 0; i < computerCount + 1; i++) {
            list.add(new HashMap<>());
        }

        for (int i = 0; i < lineCount; i++) {
            String[] inputs = br.readLine().split(" ");

            int c1 = Integer.parseInt(inputs[0]);
            int c2 = Integer.parseInt(inputs[1]);
            list.get(c1).put(c2, c2);
            list.get(c2).put(c1,c1);
        }

        dfs(1);
        System.out.println(count);

        count = 0;
        Arrays.fill(visit, false);

        bfs(1);
        System.out.println(count);
    }
    
    private static void dfs(int start) {
        visit[start] = true;

        Map<Integer, Integer> nearComputers = list.get(start);
        for (int nextComputer : nearComputers.keySet()) {
            if (!visit[nextComputer]) {
                dfs(nextComputer);
                count++;
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int computerNumber = queue.poll();

            Map<Integer, Integer> nearComputers = list.get(computerNumber);
            for (int nextComputer : nearComputers.keySet()) {
                if (!visit[nextComputer]) {
                    visit[nextComputer] = true;
                    queue.offer(nextComputer);
                    count++;
                }
            }
        }
    }

}
