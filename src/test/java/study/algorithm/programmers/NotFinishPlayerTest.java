package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class NotFinishPlayerTest {

  @Test
  public void notFinishPlayerTest() {
    NotFinishPlayer nf = new NotFinishPlayer();

    String result = nf.solution(new String[] {"mislav","stanko","mislav", "ana"}
                              , new String[] {"stanko", "mislav", "ana"});

    assertEquals("mislav", result);
  }

}