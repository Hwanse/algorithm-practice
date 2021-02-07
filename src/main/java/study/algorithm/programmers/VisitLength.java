package study.algorithm.programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Java 에서의 Set 자료구조는 내부적으로 hashCode 메소드를 호출하여 1차적으로 검증하고
 * 2차적으로 equals 메소드로 값이 값은지 다른지를 체크한다.
 * 여기서 Path 와 Point 같은 개발자가 직접 커스텀한 참조형 레퍼런스의 경우에는
 * Set 자료구조의 Element 로 활용하기 위해서 hashCode 와 equals 메소드의 오버라이딩이 반드시 필요하다
 */
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