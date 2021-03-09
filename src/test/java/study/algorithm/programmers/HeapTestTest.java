package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTestTest {

    @Test
    public void solution() throws Exception {
        HeapTest ht = new HeapTest();

        assertEquals(2, ht.solution(new int[]{1,2,3,9,10,12}, 7));
    }


}