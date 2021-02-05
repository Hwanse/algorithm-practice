package study.algorithm.programmers;

import org.junit.Assert;
import org.junit.Test;

public class MockExamTest {

  @Test
  public void mockExamTest() {
    MockExam me = new MockExam();
    int[] result = me.solution(new int[] {1, 2, 3, 4, 5});

    Assert.assertArrayEquals(new int []{1}, result);
  }

}
