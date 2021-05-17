package study.algorithm.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OrganicCabbage {

    private static int[][] map;
    private static boolean[][] visit;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseCount = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < testcaseCount; i++) {
            String[] infos = br.readLine().split(" ");
            int rowLength = Integer.parseInt(infos[0]);
            int columnLength = Integer.parseInt(infos[1]);
            int cabbageCount = Integer.parseInt(infos[2]);

            map = new int[rowLength][columnLength];
            visit = new boolean[rowLength][columnLength];
            count = 0;

            for (int j = 0; j < cabbageCount; j++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                map[x][y] = 1;
            }

            for (int x = 0; x < map.length; x++) {
                for (int y = 0; y < map[x].length; y++) {
                    if (!visit[x][y] && map[x][y] == 1) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            result.add(count);
        }

        result.forEach(System.out::println);

    }

    private static int dfs(int x, int y) {
        visit[x][y] = true;

        for (Direction dir : Direction.values()) {
            int nextX = x + dir.x;
            int nextY = y + dir.y;
            if (isInnerOfRange(nextX,nextY) && map[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }

        return count;
    }

    private static boolean isInnerOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[x].length;
    }

    enum Direction {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

        private int x;
        private int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
