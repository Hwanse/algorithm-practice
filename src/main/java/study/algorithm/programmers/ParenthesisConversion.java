package study.algorithm.programmers;

import java.util.Stack;

public class ParenthesisConversion {

    public String solution(String p) {

        if (p.isEmpty()) {
            return "";
        }

        if (isCorrectParenthesis(p)) {
            return p;
        }

        int divideIndex = dividePointIndex(p);

        String u = p.substring(0, divideIndex);
        String v = p.substring(divideIndex);

        if (isCorrectParenthesis(u)) {
            return u.concat(solution(v));
        } else {
            // u 문자열 맨 처음과 맨 뒤에 문자 지우기
            StringBuilder sb = new StringBuilder(u);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            String tempString = sb.toString();

            tempString = reverseParenthesis(tempString);

            return "(" + solution(v) + ")" + tempString;
        }

    }

    private String reverseParenthesis(String tempString) {
        char[] chars = tempString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }
        return new String(chars);
    }

    private boolean isCorrectParenthesis(String input) {
        Stack<Character> stack = new Stack<>();
        char[] inputArr = input.toCharArray();

        for (char parenthesis : inputArr) {

            if (parenthesis == '(') {
                stack.push(parenthesis);
            } else if (!stack.isEmpty() && parenthesis == ')') {
                stack.pop();
            }

        }

        return stack.isEmpty();
    }

    private int dividePointIndex(String input) {
        char[] inputArr = input.toCharArray();
        int open = 0;   // '('
        int close = 0;  // ')'
        int index = 0;

        for (char parenthesis : inputArr) {
             index++;

            if (parenthesis == '(') {
                open++;
            }
            if (parenthesis == ')') {
                close++;
            }

            if (open == close) {
                break;
            }
        }

        return index;
    }

}
