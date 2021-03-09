package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgoTestTest {

    @Test
    public void test() throws Exception {
        AlgoTest at = new AlgoTest();

        int solution1 = at.solution(2, 10, new int[]{7, 5, 5, 8});
        int solution2 = at.solution(100, 100, new int[]{10});
        int solution3 = at.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});

        assertEquals(8, solution1);
        assertEquals(101, solution2);
        assertEquals(110, solution3);
    }


}