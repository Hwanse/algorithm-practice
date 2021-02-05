package study.algorithm.programmers;

import org.junit.Assert;
import org.junit.Test;

public class VisitLengthTest {

  @Test
  public void VisitLength() {
    VisitLength vs = new VisitLength();
    int result = vs.solution("UUUUURRRLLL");

    Assert.assertEquals(8, result);
  }

}
