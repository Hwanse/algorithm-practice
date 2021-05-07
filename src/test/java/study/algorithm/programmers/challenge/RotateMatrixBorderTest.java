package study.algorithm.programmers.challenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateMatrixBorderTest {

  @Test
  public void solution() throws Exception {
    RotateMatrixBorder rm = new RotateMatrixBorder();

    assertArrayEquals(new int[]{8, 10, 25}, rm.solution(6, 6, new int[][]{{2, 2, 5, 4},
        {3, 3, 6, 6}, {5, 1, 6, 3}}));
    assertArrayEquals(new int[]{1, 1, 5, 3}, rm.solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3},
        {2, 1, 3, 2}, {2, 2, 3, 3}}));
    assertArrayEquals(new int[]{1}, rm.solution(100, 97, new int[][]{{1, 1, 100, 97}}));
  }
  
}