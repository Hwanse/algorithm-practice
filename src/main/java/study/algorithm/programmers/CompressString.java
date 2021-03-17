package study.algorithm.programmers;

import java.util.Stack;

public class CompressString {

    public int solution(final String s) {
        Stack<String> stack = new Stack<>();
        int min = s.length(); // 문자열 길이가 최대 값이므로

        for (int length = 1; length < s.length(); length++) {
            int count = 1;

            for (int startIdx = 0; startIdx < s.length(); startIdx += length) {
                int endPoint = startIdx + length;

                if (endPoint > s.length()) endPoint = s.length();

                String compareStr = s.substring(startIdx, endPoint);

                if (stack.isEmpty()) {
                    stack.push(compareStr);
                } else if (stack.peek().equals(compareStr)) {
                    count++;
                } else {

                    if (count >= 2) {
                        stack.push(count + stack.pop());
                        count = 1;
                    }
                    stack.push(compareStr);

                }

            }

            if (count >= 2) {
                stack.push(count + stack.pop());
            }

            min = Math.min(min, compressStrLength(stack));
            stack.clear();
        }

        return min;
    }

    private int compressStrLength(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();

        for (String str : stack) {
            sb.append(str);
        }
        return sb.length();
    }

}
