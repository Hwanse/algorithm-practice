package study.algorithm.sort;

/**
 * 병합 정렬은 O(n log n)의 성능을 가짐
 * 그러나 병합할 임시 배열이 정렬시에 필요하기 때문에
 * 메모리 공간이 필요하다
 */
public class MergeSort {

  public void startMergeSort(int[] arr) {
    int[] tmp = new int[arr.length];
    divide(arr, tmp, 0, arr.length - 1);
  }

  private void divide(int[] arr, int[] tmp, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      divide(arr, tmp, start, mid);
      divide(arr, tmp, mid+1, end);
      merge(arr, tmp, start, mid, end);
    }
  }

  private void merge(int[] arr, int[] tmp, int start, int mid, int end) {
    for (int i = start; i <= end; i++) {
      tmp[i] = arr[i];
    }

    int part1 = start;
    int part2 = mid + 1;
    int index = start;

    while (part1 <= mid && part2 <= end) {
      if (tmp[part1] <= tmp[part2]) {
        arr[index] = tmp[part1];
        part1++;
      } else {
        arr[index] = tmp[part2];
        part2++;
      }
      index++;
    }

    // part2(뒷 배열)은 과정이 다 끝났고 part1(앞 배열)만 값이 남아있을 때
    // 해당 나머지 part1 배열들을 원래 arr 배열에 복사하는 과정
    for (int i = part1; i <= mid; i++) {   //(int i = 0; i <= mid - part1; i++)
      arr[index++] = tmp[i];                //arr[index + i] = tmp[part1 + i];
    }
    // 반대의 경우인 part1의 과정이 다 끝나고 part2의 나머지 값들을 arr 에 넣을 필욘없다
    // 왜냐하면 이미 part1의 값들이 뒷 배열보다 더 작기때문에 정렬 과정이 마친것이기도하고
    // 이미 뒷 배열들의 값들은 원래 있던 arr 배열에 위치해 있던 남은 값들이기 때문이다.

  }

}
