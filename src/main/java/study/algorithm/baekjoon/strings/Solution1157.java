package study.algorithm.baekjoon.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Map<String, Integer> alphabetCounters = new HashMap<>();
        int max = word.length() == 1 ? 1 : -1;

        for (int i = 0; i < word.length(); i++) {
            String alphabet = word.substring(i, i + 1).toUpperCase();

            if (alphabetCounters.containsKey(alphabet)) {
                Integer beforeCount = alphabetCounters.get(alphabet);
                int incrementedCount = beforeCount + 1;
                alphabetCounters.put(alphabet, incrementedCount);
                if (max < incrementedCount) {
                    max = incrementedCount;
                }
            } else {
                alphabetCounters.put(alphabet, 1);
            }
        }


        Stack<String> stack = new Stack<>();

        for (String key : alphabetCounters.keySet()) {
            Integer count = alphabetCounters.get(key);
            if (max == count) {
                stack.push(key);
            }
        }

        if (stack.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(stack.pop());
        }

    }

}