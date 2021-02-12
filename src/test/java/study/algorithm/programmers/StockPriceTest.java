package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockPriceTest {

  @Test
  public void stockPriceTest() {
    StockPrice sp = new StockPrice();

    assertArrayEquals(new int[] {4,3,1,1,0}, sp.solution(new int[] {1,2,3,2,3}));
  }

}