package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkSolTest {

  @Test
  public void solution() {
    NetworkSol ns = new NetworkSol();
    assertEquals(2, ns.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    assertEquals(1, ns.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
  }

}