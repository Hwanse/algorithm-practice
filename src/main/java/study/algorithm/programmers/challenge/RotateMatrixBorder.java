package study.algorithm.programmers.challenge;

public class RotateMatrixBorder {

  public int[] solution(int rows, int columns, int[][] queries) {
    int[][] matrix = new int[rows][columns];
    int[] answer = new int[queries.length];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = i * columns + j + 1;
      }
    }

    for (int i = 0; i < queries.length; i++) {
      answer[i] = rotateAndReturnMinValue(matrix, queries[i]);
    }

    return answer;
  }

  private int rotateAndReturnMinValue(int[][] matrix, int[] query) {
    int x1 = query[0] - 1, y1 = query[1] - 1;
    int x2 = query[2] - 1, y2 = query[3] - 1;

    int temp = matrix[x1][y1];
    int min = temp;

    // y1 라인 시계방향으로 회전
    for (int i = x1; i < x2; i++) {
      matrix[i][y1] = matrix[i + 1][y1];
      min = Math.min(min, matrix[i][y1]);
    }
    // x2 라인 시계방향으로 회전
    for (int i = y1; i < y2; i++) {
      matrix[x2][i] = matrix[x2][i + 1];
      min = Math.min(min, matrix[x2][i]);
    }
    // y2 라인 시계방향으로 회전
    for (int i = x2; i > x1; i--) {
      matrix[i][y2] = matrix[i - 1][y2];
      min = Math.min(min, matrix[i][y2]);
    }
    // x1 라인 시계방향으로 회전
    for (int i = y2; i > y1; i--) {
      matrix[x1][i] = matrix[x1][i - 1];
      min = Math.min(min, matrix[x1][i]);
    }

    matrix[x1][y1 + 1] = temp;

    return min;
  }

  private void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.printf(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

}
