package study.algorithm.programmers.challenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTransformationIterationTest {

    @Test
    public void solution() throws Exception {
        BinaryTransformationIteration bti = new BinaryTransformationIteration();

        assertArrayEquals(new int[]{3,8}, bti.solution("110010101001"));
        assertArrayEquals(new int[]{3,3}, bti.solution("01110"));
        assertArrayEquals(new int[]{4,1}, bti.solution("1111111"));
    }


}