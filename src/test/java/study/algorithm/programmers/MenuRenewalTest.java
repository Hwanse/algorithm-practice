package study.algorithm.programmers;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class MenuRenewalTest {

  @Test
  public void solution() throws Exception {
    MenuRenewal mr = new MenuRenewal();
    assertArrayEquals(new String[]{"AC", "ACDE", "BCFG", "CDE"},
        mr.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4}));
    assertArrayEquals(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"},
        mr.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},new int[]{2, 3, 5}));
    assertArrayEquals(new String[]{"WX", "XY"},
        mr.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}));
    assertArrayEquals(new String[]{"AB", "ABC", "ABCD", "ABD", "AC", "ACD", "AD", "BC", "BCD", "BD", "CD"},
        mr.solution(new String[]{"ABCD", "ABCD", "ABCD"}, new int[]{2, 3, 4}));

  }

}