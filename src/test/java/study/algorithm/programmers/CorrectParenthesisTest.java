package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorrectParenthesisTest {

  @Test
  public void correctParenthesisTest() {
    CorrectParenthesis cp = new CorrectParenthesis();
    boolean result = cp.solution("(()))()");

    assertEquals(false, result);
  }

}