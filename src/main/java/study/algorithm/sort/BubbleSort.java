package study.algorithm.sort;

/**
 * 성능적으로 O(n^2) 의 성능
 * 이 버블소트 풀이 방식에서는 뒤에서 부터 정렬을 끝내면서 앞으로 넘어감
 */
public class BubbleSort {

  public void bubbleSort(int[] arr, int lastIndex) {
    if (lastIndex > 0) {

      for (int i = 1; i <= lastIndex; i++) {
        if (arr[i - 1] > arr[i]) {
          swap(arr, i - 1, i);
        }
      }

      bubbleSort(arr, lastIndex - 1);
    }
  }

  private void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right]  = tmp;
  }

}
