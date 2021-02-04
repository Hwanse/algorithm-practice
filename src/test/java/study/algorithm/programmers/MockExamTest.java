package study.algorithm.programmers;

import org.junit.Assert;
import org.junit.Test;

public class MockExamTest {

  @Test
  public void mockExamTest() {
    MockExam me = new MockExam();
    int[] result = me.solution(new int[] {1, 3, 2, 4, 2});

    Assert.assertArrayEquals(new int []{1,2,3}, result);
  }

}
