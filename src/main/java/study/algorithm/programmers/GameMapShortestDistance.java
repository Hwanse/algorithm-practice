package study.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 게임 맵 최단 거리 문제
 * 최단 거리로 상대 진영으로 도착한 경우의 수의 이동 거리 수를 반환해라
 *
 * - DFS는 끝까지 탐색하고 다시 다른 방향에 대하여 모든 경우의수를 끝까지 탐색해야한다.
 *   따라서 다소 비용상으로 이런 문제에선 비효율적일 확률이 높고, DFS는 모든 경우우의 수를
 *   탐색할 때가 더 유용하다고 볼 수 있다.
 * - BFS는 인접 노드들을 우선 탐색하므로 결국 칸을 이동하다보면 최단 거리로 이동하는
 *   경우의 수가 먼저 종착지에서 방문 처리를 해버리니까 그 때의 이동 거리수를 저장한
 *   배열 값을 반환하면 되는 것이다.
 */
public class GameMapShortestDistance {

  public int solution(int[][] maps) {
    int width = maps[0].length;
    int height = maps.length;
    boolean[][] visited = new boolean[height][width];
    int[][] count = new int[height][width];

    Queue<Player> queue = new LinkedList<>();
    count[0][0] = 1;
    visited[0][0] = true;
    queue.offer(new Player(0, 0));

    while (!queue.isEmpty()) {
      Player point = queue.poll();
      int currentCount = count[point.getX()][point.getY()];

      for (Direction dir : Direction.values()) {
        int nextX = point.getX() + dir.moveX();
        int nextY = point.getY() + dir.moveY();
        Player nextPoint = new Player(nextX, nextY);

        if (isNotMovable(nextX, nextY, maps, visited)) {
          continue;
        }

        count[nextX][nextY] = currentCount + 1;
        visited[nextX][nextY] = true;
        queue.offer(nextPoint);
      }
    }

    return visited[height - 1][width - 1] ? count[height - 1][width - 1] : -1;
  }

  public boolean isNotMovable(int x, int y, int[][] map, boolean[][] visited) {
    return isBoundary(x, y, map) || visited[x][y] || map[x][y] == 0;
  }

  public boolean isBoundary(int x, int y, int[][] map) {
    return x < 0 || y < 0 || x >= map.length || y >= map[0].length;
  }

}

class Player {

  private int x;
  private int y;

  public Player(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

enum Direction {
  NORTH(-1, 0), SOUTH(1, 0), WEST(0, -1), EAST(0, 1);

  private int x;
  private int y;

  private Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int moveX() {
    return x;
  }

  public int moveY() {
    return y;
  }
}