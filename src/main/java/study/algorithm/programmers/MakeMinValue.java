package study.algorithm.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeMinValue {

    public int solution(int []A, int []B) {
        int answer = 0;
        List<Integer> listA = setupList(A);
        List<Integer> listB = setupList(B);

        Collections.sort(listA);
        listB.sort(Collections.reverseOrder());

        for (int i = 0; i < listA.size(); i++) {
            answer += listA.get(i) * listB.get(i);
        }

        return answer;
    }

    private List<Integer> setupList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int value : array) {
            list.add(value);
        }
        return list;
    }

}
