package study.algorithm.programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VisitLength {

  public static final int LIMIT = 5;

  public int solution(String dirs) {
    Point startPoint = new Point(0, 0);
    Set<Path> visitedPath = new HashSet<>();
    Point beforePoint = startPoint;

    for (int i = 0; i < dirs.length(); i++) {
      Point nextPoint = null;

      switch (dirs.charAt(i)) {
        case 'U':
          nextPoint = new Point(beforePoint.x - 1, beforePoint.y);
          break;
        case 'D':
          nextPoint = new Point(beforePoint.x + 1, beforePoint.y);
          break;
        case 'L':
          nextPoint = new Point(beforePoint.x, beforePoint.y - 1);
          break;
        case 'R':
          nextPoint = new Point(beforePoint.x, beforePoint.y + 1);
          break;
        default:
          break;
      }

      // 다음 목표 지점이 범위를 벗어났는지 체크
      if (isSizeOverflow(nextPoint)) continue;

      Path currentPath = new Path(beforePoint, nextPoint);
      visitedPath.add(currentPath);
      beforePoint = nextPoint;

    }

    return visitedPath.size();
  }

  private boolean isSizeOverflow(Point point) {
    return (Math.abs(point.x) > LIMIT || Math.abs(point.y) > LIMIT);
  }

}

class Point {

  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

}

class Path {
  Point startPoint;
  Point nextPoint;

  public Path(Point startPoint, Point endPoint) {
    this.startPoint = startPoint;
    this.nextPoint = endPoint;
  }

  @Override
  public int hashCode() {
    return startPoint.hashCode() + nextPoint.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }

    Path path = (Path) o;
    return startPoint.equals(path.nextPoint) && path.startPoint.equals(nextPoint)
        || startPoint.equals(path.startPoint) && nextPoint.equals(path.nextPoint);
  }

}