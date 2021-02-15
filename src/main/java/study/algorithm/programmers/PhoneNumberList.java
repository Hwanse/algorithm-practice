package study.algorithm.programmers;

import java.util.Stack;

public class PhoneNumberList {

  public boolean solution(String[] phone_book) {
    Stack<String> stack = new Stack<>();

    for (String number : phone_book) {
      stack.add(number);
    }

    while (!stack.isEmpty()) {
      String standard = stack.pop();

      for (String phone : phone_book) {
        if (!phone.equals(standard) && phone.startsWith(standard)) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

}
