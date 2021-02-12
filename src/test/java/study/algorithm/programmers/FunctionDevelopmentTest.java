package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionDevelopmentTest {

  @Test
  public void functionDevTest() {
    FunctionDevelopment fd = new FunctionDevelopment();

    int[] result = fd.solution(new int[]{95,90,99,99,80,99}, new int[]{1,1,1,1,1,1});
    assertArrayEquals(new int[]{1,3,2}, result);

  }

}