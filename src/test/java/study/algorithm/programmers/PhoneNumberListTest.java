package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneNumberListTest {

  @Test
  public void phoneNumberListTest() {
    PhoneNumberList pl = new PhoneNumberList();
    boolean result = pl.solution(new String[] {"12","123","1235","567","88"});

    assertFalse(result);
  }

}