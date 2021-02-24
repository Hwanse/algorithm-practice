package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeNTilingTest {

  @Test
  public void solution() {
    ThreeNTiling tt = new ThreeNTiling();
    assertEquals(11, tt.solution(4));
  }

}