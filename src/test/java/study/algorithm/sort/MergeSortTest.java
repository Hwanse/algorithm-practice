package study.algorithm.sort;


import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

  @Test
  public void mergeSortTest() {
    int[] arr = new int[] {1, 8, 3, 10, 7, 5, 6, 9, 2, 4};
    MergeSort ms = new MergeSort();

    ms.startMergeSort(arr);
    Assert.assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9,10}, arr);
  }

}
