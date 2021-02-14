package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionDevelopmentTest {

  @Test
  public void functionDevTest() {
    FunctionDevelopment fd = new FunctionDevelopment();

    int[] result = fd.solution(new int[]{93,30,55}, new int[]{1,30,5});
    assertArrayEquals(new int[]{2,1}, result);

  }

}