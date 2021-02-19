package study.algorithm.programmers;

public class NetworkSol {

  public int solution(int n, int[][] computers) {
    int answer = 0;
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visitComputer(computers, i, visited);
        answer++;
      }
    }

    return answer;
  }

  private void visitComputer(int[][] computers, int index, boolean[] visited) {
    visited[index] = true;

    for (int j = 0; j < computers.length; j++) {
      if (index != j && !visited[j] && computers[index][j] == 1) {
        visitComputer(computers, j, visited);
      }
    }
  }

}
