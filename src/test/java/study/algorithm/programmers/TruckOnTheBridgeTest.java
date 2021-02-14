package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TruckOnTheBridgeTest {

  @Test
  public void truckTest() {
    TruckOnTheBridge tb = new TruckOnTheBridge();
    int result = tb.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});

    assertEquals(110, result);
  }

}