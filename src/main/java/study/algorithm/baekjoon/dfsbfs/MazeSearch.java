package study.algorithm.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MazeSearch {

    private static int[][] maze;
    private static int[][] temp;

    private static final int NOT_ROAD = 0;
    private static final int ROAD = 1;
    private static final int VISIT_ROAD = 2;
    private static final int BLOCK_ROAD = 3;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        maze = new int[n][m];
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                maze[i][j] = input.charAt(j) - '0';
                temp[i][j] = input.charAt(j) - '0';
            }
        }



    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void search(int x, int y) {
        if (temp[x][y] == NOT_ROAD || temp[x][y] == BLOCK_ROAD) {
            return;
        }
    }

    private static boolean isInnerOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[x].length;
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
