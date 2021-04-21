package study.algorithm.programmers.challenge;

import java.util.Stack;

public class RotateParentheses {

    public int solution(String s) {
        int answer = 0;
        String str = s;

        for (int i = 0; i < s.length(); i++) {

            if (i > 0) {
                String postFix = str.substring(1);
                String rotatedStr = postFix.concat(str.substring(0, 1));
                str = rotatedStr;
            }

            if (check(str)) {
                answer++;
            }

        }

        return answer;
    }

    private boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        if (! (str.contains("{") || str.contains("(") || str.contains("[")) ) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char nextToken = str.charAt(i);

            if (nextToken != '}' && nextToken != ')' && nextToken != ']') {
                stack.push(nextToken);
            } else {
                if (!stack.isEmpty()) {
                    char currentToken = stack.peek();

                    if (currentToken == '{' && nextToken == '}' ||
                        currentToken == '(' && nextToken == ')' ||
                        currentToken == '[' && nextToken == ']' ) {
                        stack.pop();
                    }
                }
            }

        }

        return stack.isEmpty();
    }

}
