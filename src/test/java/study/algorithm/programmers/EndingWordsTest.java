package study.algorithm.programmers;


import org.junit.Assert;
import org.junit.Test;

public class EndingWordsTest {

  @Test
  public void endingWordsTest() {
    EndingWords ew = new EndingWords();
    int[] result = ew.solution(3, new String []{"tank", "kick", "konw", "whell", "ld", "dm", "mr", "rt","tank"});

    Assert.assertArrayEquals(new int[] {3,3}, result);

  }

}
