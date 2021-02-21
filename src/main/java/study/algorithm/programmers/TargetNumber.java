package study.algorithm.programmers;

public class TargetNumber {

  public int solution(int[] numbers, int target) {
    return makeTargetNumber(numbers, 0, 0, target);
  }

  private int makeTargetNumber(int[] numbers, int index, int sum, int target) {
    if (index >= numbers.length) {
      return (sum == target) ? 1 : 0;
    }

    return makeTargetNumber(numbers, index + 1, sum + numbers[index], target)
         + makeTargetNumber(numbers, index + 1, sum - numbers[index], target);
  }

}
