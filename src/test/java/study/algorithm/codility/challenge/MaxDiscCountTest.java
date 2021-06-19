package study.algorithm.codility.challenge;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class MaxDiscCountTest {

    @Test
    public void test() throws Exception {
        MaxDiscCount mdc = new MaxDiscCount();

        assertEquals(3, mdc.solution(new int[]{2,3,3,4},3, 1));
        assertEquals(4, mdc.solution(new int[]{1,4,5,5},6, 4));
        assertEquals(4, mdc.solution(new int[]{5,2,5,2},8, 1));
        assertEquals(2, mdc.solution(new int[]{1,5,5},2, 4));
    }

}