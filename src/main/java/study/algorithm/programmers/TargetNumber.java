package study.algorithm.programmers;

public class TargetNumber {

  private int answer = 0;

  public int solution(int[] numbers, int target) {
    makeTargetNumber(numbers, 0, 0, target);

    return answer;
  }

  private void makeTargetNumber(int[] numbers, int index, int sum, int target) {
    if (index >= numbers.length) {
      if (sum == target) {
        answer++;
      }
      return;
    }

    makeTargetNumber(numbers, index + 1, sum + numbers[index], target);
    makeTargetNumber(numbers, index + 1, sum - numbers[index], target);
  }

}
