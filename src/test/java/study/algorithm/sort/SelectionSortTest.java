package study.algorithm.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionSortTest {

  @Test
  public void selectionSort() {
    int[] arr = new int[] {1, 8, 6, 5, 7, 10, 3, 9, 2, 4};
    SelectionSort ss = new SelectionSort();

    ss.selectionSort(arr, 0);
    assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9,10}, arr);
  }

}