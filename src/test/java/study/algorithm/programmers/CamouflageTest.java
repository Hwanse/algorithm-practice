package study.algorithm.programmers;

import static org.junit.Assert.*;

import java.util.Map;
import org.junit.Test;

public class CamouflageTest {

  @Test
  public void camouflageTest() {
    Camouflage cf = new Camouflage();
    int result = cf.solution(new String[][]{
                                  {"y", "headgear"},
                                  {"x", "eyewear"},
                                  {"x", "headgear"}
                              });

    assertEquals(5, result);
  }

}