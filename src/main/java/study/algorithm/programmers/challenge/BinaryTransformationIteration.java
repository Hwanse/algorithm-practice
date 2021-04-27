package study.algorithm.programmers.challenge;

public class BinaryTransformationIteration {

    public int[] solution(String s) {
        String x = s;

        int convertCount = 0;
        int deleteCount = 0;

        while (!"1".equals(x)){
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < x.length(); i++) {
                char value = x.charAt(i);

                if (value - '0' != 0) {
                    sb.append(value);
                } else {
                    deleteCount++;
                }
            }

            x = Integer.toBinaryString(sb.length());
            convertCount++;
        }

        return new int[]{convertCount, deleteCount};
    }

}
