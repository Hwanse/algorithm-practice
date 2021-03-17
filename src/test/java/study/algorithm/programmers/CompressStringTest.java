package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompressStringTest {

    @Test
    public void solution() {
        CompressString cs = new CompressString();

        assertEquals(7, cs.solution("aabbaccc"));
        assertEquals(9, cs.solution("ababcdcdababcdcd"));
        assertEquals(8, cs.solution("abcabcdede"));
        assertEquals(14, cs.solution("abcabcabcabcdededededede"));
        assertEquals(17, cs.solution("xababcdcdababcdcd"));
        assertEquals(1, cs.solution("a"));
    }


}