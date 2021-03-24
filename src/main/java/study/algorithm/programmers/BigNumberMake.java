package study.algorithm.programmers;

public class BigNumberMake {

    public String solution(String number, int k) {
        String answer = "";

        int index = -1;


        for (int x = 0; x < number.length() - k; x++) {
            int max = -1;

            for (int y = index + 1; y <= k + x; y++) {
                int target = number.charAt(y) - '0';

                if (max < target) {
                    index = y;
                    max = target;
                    if (max == 9) break; // case 10 ex) 99999 ..
                }
            }

            answer += max;
        }

        return answer;
    }


}
