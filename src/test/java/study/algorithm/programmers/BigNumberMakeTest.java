package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class BigNumberMakeTest {

    @Test
    public void solution() throws Exception {
        BigNumberMake bm = new BigNumberMake();

        assertEquals("94", bm.solution("1924", 2));
        assertEquals("3234", bm.solution("1231234", 3));
        assertEquals("775841", bm.solution("4177252841", 4));
        assertEquals("99", bm.solution("999999", 2));
    }


}