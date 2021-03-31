package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakeMinValueTest {

    @Test
    public void solution() throws Exception {
        MakeMinValue mmv = new MakeMinValue();

        assertEquals(29, mmv.solution(new int[]{1,4,2}, new int[]{5,4,4}));
        assertEquals(10, mmv.solution(new int[]{1,2}, new int[]{3,4}));
    }


}