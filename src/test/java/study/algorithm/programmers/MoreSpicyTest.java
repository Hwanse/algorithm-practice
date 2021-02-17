package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoreSpicyTest {

  @Test
  public void moreSpicy() {
    MoreSpicy ms = new MoreSpicy();

    assertEquals(2, ms.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
  }

}