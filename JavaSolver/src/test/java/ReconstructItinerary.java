import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructItinerary {

    private List<String> ans = new ArrayList<>();

    @Test
    public void run() {
        List<List<String>> input = new ArrayList<>();

        input.add(Arrays.asList(new String[] {"JFK","SFO"}));
        input.add(Arrays.asList(new String[] {"JFK","ATL"}));
        input.add(Arrays.asList(new String[] {"SFO","ATL"}));
        input.add(Arrays.asList(new String[] {"ATL","JFK"}));
        input.add(Arrays.asList(new String[] {"ATL","SFO"}));

        /*
        input.add(Arrays.asList(new String[] {"JFK","AAA"}));
        input.add(Arrays.asList(new String[] {"AAA","JFK"}));
        input.add(Arrays.asList(new String[] {"JFK","BBB"}));
        input.add(Arrays.asList(new String[] {"JFK","CCC"}));
        input.add(Arrays.asList(new String[] {"CCC","JFK"}));


         */
        // ["JFK","AAA","JFK","CCC","JFK","BBB"]


        findItinerary(input).forEach(s -> System.out.print(s + " "));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        ans.add("JFK");

        tickets.sort((o1, o2) -> {
            int comp1 = o1.get(0).compareTo(o2.get(0));
            if (comp1 != 0) {
                return comp1;
            } else {
                return o1.get(1).compareTo(o2.get(1));
            }
        });

        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals("JFK")) {
                boolean[] visited = new boolean[tickets.size()];
                visited[i] = true;
                List<String> list = new ArrayList<>();
                dfs(i, tickets, visited, list);
                if (ans.size() == tickets.size()) {
                    ans.add(0, "JFK");
                    return ans;
                }
//                String[] arr = answer.split(" ");
//                if (arr.length > tickets.size()) {
//                    return Arrays.asList(arr);
//                }
            }
        }

        return ans;
    }

    private void dfs(int index, List<List<String>> tickets, boolean[] visited, List<String> answer) {
        String dep = tickets.get(index).get(0);
        String arv = tickets.get(index).get(1);

        for (int i = 0; i < tickets.size(); i++) {
            String tarDep = tickets.get(i).get(0);
            String tarArv = tickets.get(i).get(1);
            if (i != index && arv.equals(tarDep) && !visited[i]) {
                visited[i] = true;
                answer.add(arv);
                dfs(i, tickets, visited, answer);
                if (answer.size() == tickets.size()) {
                    return;
                } else {
                    visited[i] = false;
                    answer.remove(answer.size() - 1);
                }
            }
        }

        answer.add(arv);
        if (answer.size() == tickets.size()) {
            answer.forEach(s -> System.out.print(s + " "));
            System.out.println();
            ans = answer;
        } else {
            answer.remove(answer.size() - 1);
        }
    }
}
