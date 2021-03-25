package study.algorithm.programmers;

public class Carpet {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // a: 가로길이 / b: 세로길이
        // totalCount = 2a + 2b + 4
        for (int i = yellow; i >= (yellow / i); i--) {
            if (yellow % i != 0) {
                continue;
            }
            if ( ((2 * i) + (2 * (yellow / i)) + 4) == brown ) {
                answer[0] = 2 + i;
                answer[1] = (yellow / i) + 2;
                break;
            }

        }

        return answer;
    }

}
