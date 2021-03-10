package study.algorithm.programmers;

// 규칙성을 찾아야함
public class Problem124Country {

    private final int[] numbers = new int[] {4, 1, 2};

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int decimal = n;

        while (decimal > 0) {
            int remainder = decimal % 3;
            decimal /= 3;

            // 나머지가 0으로 나누어 떨어지는 순간 자리수가 변경이되며
            // 해당 자리수 값이 예시대로 제대로 나올려면 -1 씩 연산되어야하는
            // 규칙성이 있다.
            if (remainder == 0) {
                decimal--;
            }

            answer.insert(0, numbers[remainder]);
        }

        return answer.toString();
    }

}
