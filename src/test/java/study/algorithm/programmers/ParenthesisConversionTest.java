package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParenthesisConversionTest {

    @Test
    public void solution() throws Exception {
        ParenthesisConversion pc = new ParenthesisConversion();

        assertEquals("(()())()", pc.solution("(()())()"));
        assertEquals("()", pc.solution("()"));
        assertEquals("()(())()", pc.solution("()))((()"));
        assertEquals("((()))", pc.solution(")()()("));
    }


}