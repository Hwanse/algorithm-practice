package study.algorithm.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 인접 리스트를 구현화한 방식으로 풀이
 *
 * 1 -> [1, 2, 3]
 * 2 -> [1, 3]
 * 3 -> [1, 2]
 *
 */
public class DfsAndBfsAnotherSol {

    private static List<TreeMap<Integer, Integer>> list = new ArrayList<>();
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int start = Integer.parseInt(inputs[2]);
        visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new TreeMap<>());
        }

        for (int i = 0; i < m; i++) {
            String[] values = br.readLine().split(" ");
            int p1 = Integer.parseInt(values[0]);
            int p2 = Integer.parseInt(values[1]);

            list.get(p1).put(p2, p2);
            list.get(p2).put(p1, p1);
        }

        dfs(start);

        System.out.println();
        Arrays.fill(visit, false);

        bfs(start);
    }

    private static void dfs(int nodeNumber) {
        visit[nodeNumber] = true;
        System.out.printf(nodeNumber + " ");

        TreeMap<Integer, Integer> nextNodes = list.get(nodeNumber);

        for (int node : nextNodes.keySet()) {
            if (!visit[node]) {
                visit[node] = true;
                dfs(node);
            }
        }
    }

    private static void bfs(int nodeNumber) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nodeNumber);
        visit[nodeNumber] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.printf(currentNode + " ");

            TreeMap<Integer, Integer> nextNodes = list.get(currentNode);
            for (int node : nextNodes.keySet()) {
                if (!visit[node]) {
                    visit[node] = true;
                    queue.offer(node);
                }
            }
        }
    }
}
