package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriceTestTest {

    @Test
    public void solution() throws Exception {
        PriceTest pt = new PriceTest();

        assertArrayEquals(new int[]{4,3,1,1,0}, pt.solution(new int[]{1,2,3,2,3}));
    }


}