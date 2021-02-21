import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < computers.length; i++) visited.add(-1);

        for (int i = 0; i < computers.length; i++) {
            if (visited.get(i) == -1) {
                visited.set(i, i);
                search(i, i, visited, computers);
            }
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        visited.forEach(v -> {
            resultMap.put(v, 1);
        });

        answer = resultMap.size();

        return answer;
    }

    public void search(int v, int marker, List<Integer> visited, int[][] computers) {
        for (int i = 0; i < computers[v].length; i++) {
            if (i != v && computers[v][i] == 1 && visited.get(i) == -1) {
                visited.set(i, marker);
                search(i, marker, visited, computers);
            }
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();

        System.out.println("\n" + 
            s.solution(
                /* 3,
                new int[][] {
                    {1, 1, 0},
                    {1, 1, 0},
                    {0, 0, 1}
                }) */
                4,
                new int[][] {
                    {1, 1, 0, 0},
                    {1, 1, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}
                })
        );
    }
}
