package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxAndMinTest {

    @Test
    public void solution() throws Exception {
        MaxAndMin mm = new MaxAndMin();

        assertEquals("1 4", mm.solution("1 2 3 4"));
        assertEquals("-4 -1", mm.solution("-1 -2 -3 -4"));
        assertEquals("-1 -1", mm.solution("-1 -1"));
    }


}