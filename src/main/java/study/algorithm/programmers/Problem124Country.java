package study.algorithm.programmers;

public class Problem124Country {

    private final int[] numbers = new int[] {4, 1, 2};

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int decimal = n;

        while (decimal > 0) {
            int remainder = decimal % 3;
            decimal /= 3;

            if (remainder == 0) {
                decimal--;
            }

            answer.insert(0, numbers[remainder]);
        }

        return answer.toString();
    }

}
