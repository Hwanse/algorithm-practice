package study.algorithm.programmers.challenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateParenthesesTest {

    @Test
    public void solution() throws Exception {
        RotateParentheses rp = new RotateParentheses();

        assertEquals(3, rp.solution("[](){}"));
        assertEquals(2, rp.solution("}]()[{"));
        assertEquals(0, rp.solution("[)(]"));
        assertEquals(0, rp.solution("}}}"));
    }


}