package study.algorithm.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ComplexNumbering {

    private static int[][] map;
    private static boolean[][] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> results = new ArrayList<>();
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    results.add(count);
                }
            }
        }

        System.out.println(results.size());
        Collections.sort(results);
        results.forEach(System.out::println);
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;

        for (Direction dir : Direction.values()) {
            int nextX = x + dir.x;
            int nextY = y + dir.y;
            if (isInnerOfRange(nextX,nextY) && map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
                count++;
            }
        }

        return count;
    }

    private static boolean isInnerOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map.length;
    }

    public enum Direction {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

        private int x;
        private int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
