package study.algorithm.sort;


import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

  @Test
  public void quickSortTest() {
    int[] arr = new int[] {6, 8, 10, 3, 5, 7, 1, 9, 2, 4};
    QuickSort qs = new QuickSort();

    qs.quickSort(arr, 0, arr.length - 1);
    Assert.assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9,10}, arr);
  }

}
