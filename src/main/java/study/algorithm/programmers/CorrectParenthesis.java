package study.algorithm.programmers;

import java.util.Stack;

/**
 * 다음 문제는 효율성 테스트 케이스에서 계속 실패했었다.
 * 원인은 2 가지로 예상된다.
 * 1. 불필요한 for 문을 돌지 않아도 되는 case
 *  - input 문자열에서 가장 첫글자가 ')' 일 때랑 마지막 글자가 '('일 때에는 이미 조건을 만족하지 못한다
 *    따라서 이 경우에는 바로 false 를 return 해줘야 효율적
 *  - loop 를 돌면서 stack 이 비어있을 때(올바른 괄호들이 빠져나간 순간) ')' 가 들어오면 이미
 *    그것은 문제 조건을 만족할 수 없다. 따라서 그 경우에도 바로 false 를 return 해주는 것이 효율적
 *
 * 2. String 을 사용해서
 *  - String 은 참조형이며 결국 String 관련 함수들은 내부적으로 많은 연산들이 처리된다.
 *  - equals 메소드로 비교하는 행위 및 스택에 push, pop 연산을 할 때에도 내부적으로 cost 가 많이 소모될 것
 */
public class CorrectParenthesis {

  boolean solution(String s) {
    Stack<Character> stack = new Stack<>();

    if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
      return false;
    }

    for (Character token : s.toCharArray()) {

      if (token == '(') {
        stack.push(token);
      } else {
        if (stack.isEmpty()) {
          return false;
        } else {
          stack.pop();
        }
      }

    }

    return (stack.isEmpty()) ? true : false;
  }

}
