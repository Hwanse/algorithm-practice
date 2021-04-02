package study.algorithm.programmers;

public class TriangularSnail {

    // 방법 1
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int sum = getSum(n);
        int[] answer = new int[sum];

        int number = 1;
        int x = 0, y = 0;

        triangle[x][y] = number;

        while (number < sum) {

            // 세로 아래
            while (x + 1 < n && number < sum && triangle[x + 1][y] == 0) {
                triangle[++x][y] = ++number;
            }


            // 가로 우측
            while (y + 1 < n && number < sum && triangle[x][y + 1] == 0) {
                triangle[x][++y] = ++number;
            }


            // 북서쪽 방향
            while (x - 1 > 0 && y - 1 > 0 && number < sum && triangle[x - 1][y - 1] == 0) {
                triangle[--x][--y] = ++number;
            }

        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }

    private int getSum(int n) {
        if (n == 1) {
            return 1;
        }

        return getSum(n - 1) + n;
    }

    // 방법 2
    /*public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int k = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }*/

}
