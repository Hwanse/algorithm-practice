package study.algorithm.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MazeSearch {

    private static int[][] maze;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        maze = new int[n][m];
        visited = new int[n][m];
        

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }

        search(0, 0);
        System.out.println(visited[n - 1][m - 1]);

    }

    private static void search(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int currentX = location[0];
            int currentY = location[1];

            for (Direction dir : Direction.values()) {
                int nextX = currentX + dir.x;
                int nextY = currentY + dir.y;

                if (checkLocation(nextX, nextY)) {
                    queue.offer(new int[] {nextX, nextY});
                    visited[nextX][nextY] = visited[currentX][currentY] + 1;
                }
            }
        }
    }

    private static boolean isInnerOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[x].length;
    }

    private static boolean checkLocation(int x, int y) {
        if (!isInnerOfRange(x, y)) {
            return false;
        }
        if (maze[x][y] == 0 || visited[x][y] != 0) {
            return false;
        }
        return true;
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
