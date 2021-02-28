package study.algorithm.programmers;

import java.util.Arrays;

public class LifeBoat {

    public int solution(int[] people, int limit) {
        int answer = 0;

        int left = 0;
        int right = people.length - 1;

        Arrays.sort(people);

        while (left < right) {
            answer++;

            int sum = people[left] + people[right];

            if (sum > limit) {
                right--;
                continue;
            }

            left++;
            right--;
        }

        if(left == right) answer++;

        return answer;
    }

}