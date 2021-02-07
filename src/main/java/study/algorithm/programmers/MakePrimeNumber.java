package study.algorithm.programmers;

/**
 * 최적의 알고리즘 에라토스테네스의 체
 * 주어진 자연수 N이 소수이기 위한 필요 충분 조건은 N이 N의 제곱근보다 크지 않은
 * 어떤 소수로도 나누어지지 않는다. 수가 수를 나누면 몫이 생기고 몫과 나눈 수
 * 둘 중 하나는 반드시 N의 제곱근 이하이기 때문이다.
 */
public class MakePrimeNumber {

  private static final int VISIT = 1;
  private static final int NOT_VISIT = 0;

  static int primeNumberCount = 0;
  static int[] isVisitArr;

  public int solution(final int[] nums) {
    isVisitArr = new int[nums.length];

    for (int x = 0; x < nums.length; x++) {
      isVisitArr[x] = VISIT;
      for (int y = x + 1; y < nums.length; y++) {
        isVisitArr[y] = VISIT;
        for(int z = y + 1; z < nums.length; z++) {
          isVisitArr[z] = VISIT;

          // sum 값 계산
          int sum = calulateSum(nums[x], nums[y], nums[z]);
          if (isPrime(sum)) primeNumberCount++;

          isVisitArr[z] = NOT_VISIT;
        }
        isVisitArr[y] = NOT_VISIT;
      }
      isVisitArr[x] = NOT_VISIT;
    }

    return primeNumberCount;
  }

  private int calulateSum(int... numbers) {
    int sum = 0;

    for (int i = 0; i < numbers.length; i++) {
      sum += numbers[i];
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
