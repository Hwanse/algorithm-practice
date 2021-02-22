package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameMapShortestDistanceTest {

  @Test
  public void solution() {
    GameMapShortestDistance game = new GameMapShortestDistance();
    assertEquals(11 , game.solution(new int[][] {
        {1, 0, 1, 1, 1},
        {1, 0, 1, 0, 1},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 0, 1},
        {0, 0, 0, 0, 1}
    }));
  }

}