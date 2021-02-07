package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class KNumberTest {

  @Test
  public void kNumberTest() {
    KNumber kn = new KNumber();
    int[] arr = new int[]{1,5,2,6,3,7,4};
    int[][] commands = {
        {2,5,3},
        {4,4,1},
        {1,7,3}
    };

    int[] result = kn.solution(arr, commands);

    assertArrayEquals(new int[] {5,6,3}, result);
  }

}