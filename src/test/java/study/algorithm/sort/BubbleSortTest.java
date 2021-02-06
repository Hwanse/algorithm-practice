package study.algorithm.sort;


import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

  @Test
  public void bubbleSortTest() {
    int[] arr = new int[] {1, 8, 6, 5, 7, 10, 3, 9, 2, 4};
    BubbleSort bs = new BubbleSort();

    bs.bubbleSort(arr, arr.length - 1);
    Assert.assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9,10}, arr);
  }

}
