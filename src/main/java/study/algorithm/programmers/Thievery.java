package study.algorithm.programmers;

public class Thievery {

    public int solution(int[] money) {
        int[] firstDp = new int[money.length - 1];
        int[] lastDp = new int[money.length];

        // 첫 번째 집을 도둑질한 경우의 수
        firstDp[0] = money[0];
        firstDp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < firstDp.length; i++) {
            firstDp[i] = Math.max(firstDp[i - 2] + money[i], firstDp[i - 1]);
        }

        // 마지막 집을 도둑질한 경우의 수
        lastDp[0] = 0;
        lastDp[1] = money[1];
        for (int i = 2; i < lastDp.length; i++) {
            lastDp[i] = Math.max(lastDp[i - 2] + money[i], lastDp[i - 1]);
        }

        return Math.max(firstDp[firstDp.length - 1], lastDp[lastDp.length - 1]);
    }

}
