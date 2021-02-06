package study.algorithm.sort;

/**
 * 퀵 정렬은 평균적으로 O(n log n)이긴하나
 * worst case 일 경우 O(n^2)이 나온다
 */
public class QuickSort {

  public void quickSort(int[] arr, int start, int end) {
    int mid = partition(arr, start, end);

    if (start < mid - 1) {
     quickSort(arr, start, mid - 1);
    }
    if (mid < end) {
     quickSort(arr, mid, end);
    }
  }

  private int partition(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];

    while (left <= right) {
      while (arr[left] < pivot) left++;
      while (pivot < arr[right]) right--;

      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }

    return left;
  }

  private void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }

}
