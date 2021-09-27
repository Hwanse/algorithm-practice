package study.algorithm.baekjoon.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 숫자 1 == 2초, 숫자가 증가할때마다 시간은 1초씩 증가한다
 * 각 숫자별로 대칭되는 문자들이 있고 주어진 문자들의 조합으로 입력해야하는 숫자들을 도출하고
 * 입력 값을 처리하기 위한 최소 시간을 구하라
 */
public class Solution5622 {

    private static Map<Character, Integer> dials = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = br.readLine();

        int time = 0;
        initialize();

        for (int i = 0; i < inputValue.length(); i++) {
            char word = inputValue.charAt(i);
            time += dials.get(word) + 1;
        }

        System.out.println(time);
    }

    /**
     * 입력받은 각 문자에 대응되는 숫자를 map에 초기화 시킨다
     */
    public static void initialize() {
        char word = 'A';

        for (int number = 2; number <= 9; number++) {
            if (number == 7 || number == 9) {
                for (int i = 0; i < 4; i++) {
                    dials.put(word++, number);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    dials.put(word++, number);
                }
            }
        }
    }

}
