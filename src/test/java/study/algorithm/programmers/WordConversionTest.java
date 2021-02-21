package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordConversionTest {

  @Test
  public void solution() {
    WordConversion wc = new WordConversion();

    assertEquals(4, wc.solution("hit","cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    assertEquals(0, wc.solution("hit","cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
  }

}