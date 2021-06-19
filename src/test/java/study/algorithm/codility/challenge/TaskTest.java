package study.algorithm.codility.challenge;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskTest {

    @Test
    public void test() throws Exception {
        Task task = new Task();

        assertEquals("adcede", task.solution("decade", 4));
    }

}