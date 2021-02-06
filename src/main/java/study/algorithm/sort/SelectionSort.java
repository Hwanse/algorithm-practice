package study.algorithm.sort;

/**
 * 선택 정렬 시간 복잡도 : O(n^2)
 */
public class SelectionSort {

  public void selectionSort(int[] arr, int startIndex) {
    if (startIndex < arr.length - 1) {
      int minIndex = startIndex;

      for (int i = startIndex; i < arr.length; i++) {
        if (arr[minIndex] > arr[i]) {
          minIndex = i;
        }
      }

      swap(arr, startIndex, minIndex);
      selectionSort(arr, startIndex + 1);
    }
  }

  private void swap(int[] arr, int startIndex, int minIndex) {
    int tmp = arr[startIndex];
    arr[startIndex] = arr[minIndex];
    arr[minIndex] = tmp;
  }

}
