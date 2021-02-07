package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringsSortTest {

  @Test
  public void StringSortTest() {
    StringsSort ss = new StringsSort();
    String[] result = ss.solution(new String[]{"abce","abcd","cdx"}, 2);

    assertArrayEquals(new String[]{"abcd", "abce", "cdx"}, result);
  }

}