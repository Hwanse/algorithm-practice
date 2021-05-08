package study.algorithm.programmers;

import java.util.*;

public class TravelRoute {

    private List<String> answers;
    private boolean[] visited;

    public String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];

        int visitCount = 0; // 방문한 경로의 수
        dfs(tickets, "ICN", "ICN", visitCount);
        Collections.sort(answers);

        return answers.get(0).split(" ");
    }

    private void dfs(String[][] tickets, String destination, String route, int visitCount) {
        if (visitCount == tickets.length) {
            answers.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String ticketFrom = tickets[i][0];
            String ticketDestination = tickets[i][1];
            if (!visited[i] && destination.equals(ticketFrom)) {
                visited[i] = true;
                dfs(tickets, ticketDestination, route + " " + ticketDestination, visitCount + 1);
                visited[i] = false;
            }
        }
    }


}