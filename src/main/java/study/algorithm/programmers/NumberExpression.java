package study.algorithm.programmers;

public class NumberExpression {

    public int solution(int n) {
        int answer = 0;
        int[] numbers = createNumbers(n);

        for (int x = 0; x < n; x++) {
            int sum = 0;

            for (int y = x; y < n; y++) {
                sum += numbers[y];

                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }

        }

        return answer;
    }

    private int[] createNumbers(int n) {
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        return numbers;
    }

}
