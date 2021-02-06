package study.algorithm.programmers;

/**
 *
 */
public class MakePrimeNumberDFS {

  static boolean[] isSelectArray;
  static int primeNumberCnt = 0;

  public int solution(final int[] nums) {
    isSelectArray = new boolean[nums.length];
    numberCombination(nums, 0, 3);
    return primeNumberCnt;
  }

  private void numberCombination(int[] nums, int start, int count) {
    if (count == 0) {

      if (isPrime(calculateSum(nums))) {
        primeNumberCnt++;
      }

    }

    for (int i = start; i < nums.length; i++) {
      if (!isSelectArray[i]) {
        isSelectArray[i] = true;
        numberCombination(nums, i, count - 1);
        isSelectArray[i] = false;
      }
    }
  }

  private int calculateSum(int[] nums) {
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      if (isSelectArray[i]) {
        sum += nums[i];
      }
    }

    return sum;
  }

  private boolean isPrime(int number) {
    int squareRoot = (int) Math.sqrt(number);

    for (int i = 2; i <= squareRoot; i++) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

}
