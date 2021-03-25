package study.algorithm.programmers;

import java.util.Stack;

public class PracticalParenthesis {

    boolean solution(final String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (char bracket : charArray) {

            if (bracket == ')') {

                if (stack.isEmpty()) {
                    stack.push(bracket);
                } else {
                    stack.pop();
                }

            } else {
                stack.push(bracket);
            }

        }

        return stack.isEmpty();
    }

}
