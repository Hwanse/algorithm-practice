package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TruckOnTheBridgeTest {

  @Test
  public void truckTest() {
    TruckOnTheBridge tb = new TruckOnTheBridge();
    int result = tb.solution(2,10, new int[]{7,4,5,6});

    assertEquals(8, result);
  }

}