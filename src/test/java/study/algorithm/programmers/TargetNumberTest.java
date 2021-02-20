package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TargetNumberTest {

  @Test
  public void solution() {
    TargetNumber tn = new TargetNumber();
    assertEquals(5, tn.solution(new int[]{1, 1, 1, 1, 1}, 3));
  }

}