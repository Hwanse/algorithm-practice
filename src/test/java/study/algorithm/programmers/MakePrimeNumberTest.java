package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakePrimeNumberTest {

  @Test
  public void makePrimeNumberTest() {
    int[] arr = new int[] {1, 2, 7, 6, 4};
    MakePrimeNumber mpn = new MakePrimeNumber();

    int result = mpn.solution(arr);
    assertEquals(4, result);

  }

}