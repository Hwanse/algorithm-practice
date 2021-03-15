package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeastCommonMultipleTest {

    @Test
    public void solution() throws Exception {
        LeastCommonMultiple lcm = new LeastCommonMultiple();

        assertEquals(168, lcm.solution(new int[] {2,6,8,14}));
        assertEquals(6, lcm.solution(new int[] {1,2,3}));
    }


}