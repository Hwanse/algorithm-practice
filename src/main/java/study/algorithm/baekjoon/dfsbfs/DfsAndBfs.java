package study.algorithm.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 풀이 키워드
 * 1. 인접 행렬 (장점: 간단하게 표현 가능한 방식 / 단점: 정점이 많아질 수록 프로그램 수행 속도가 느려진다. 시간복잡도 증가)
 * 2. 인접 리스트 (장점: 인접 행렬에 비해 메모리 용량 차지가 적고, 시간 복잡도가 감소 / 단점: 간선의 인접 여부를 확인하기 위해서 양쪽 다 확인 작업이 필요)
 *
 * # 인접행렬이란?
 *     1 2 3
 *     _ _ _
 * 1 | 0 1 0
 * 2 | 1 0 1
 * 3 | 0 1 0
 *
 * 위 그림과 같은 형태로 꼭지점끼리 연결된 간선을 인접 행렬의 형태로 표현하는 것임 (1: 연결됨 / 0: 연결되지 않음)
 *
 */
public class DfsAndBfs {

    private static int[][] matrix;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int start = Integer.parseInt(inputs[2]);
        visit = new boolean[n + 1];
        matrix = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] values = br.readLine().split(" ");

            int p1 = Integer.parseInt(values[0]);
            int p2 = Integer.parseInt(values[1]);

            matrix[p1][p2] = 1;
            matrix[p2][p1] = 1;
        }

        dfs(start);

        System.out.println();
        Arrays.fill(visit, false);

        bfs(start);
    }

    private static void dfs(int nodeNumber) {
        visit[nodeNumber] = true;
        System.out.printf(nodeNumber + " ");

        for(int i = 1; i < matrix[nodeNumber].length; i++) {
            if (!visit[i] && matrix[nodeNumber][i] == 1) {
                dfs(i);
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

            for (int i = 1; i < matrix[currentNode].length; i++) {
                if (!visit[i] && matrix[currentNode][i] == 1) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

}