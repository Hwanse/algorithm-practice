package study.algorithm.programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class TravelRouteTest {

    @Test
    public void solution() throws Exception {
        TravelRoute tr = new TravelRoute();

        assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"},
                tr.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"},{"JFK", "HND"}}));
        assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},
                tr.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}));
    }

}