import org.junit.jupiter.api.Test;

import java.util.*;

public class ReconstructItinerary {

    private List<String> path = new ArrayList<>();

    @Test
    public void run() {
        List<List<String>> input = new ArrayList<>();

        /*
        input.add(Arrays.asList(new String[] {"JFK","SFO"}));
        input.add(Arrays.asList(new String[] {"JFK","ATL"}));
        input.add(Arrays.asList(new String[] {"SFO","ATL"}));
        input.add(Arrays.asList(new String[] {"ATL","JFK"}));
        input.add(Arrays.asList(new String[] {"ATL","SFO"}));
        */

        input.add(Arrays.asList(new String[] {"JFK","AAA"}));
        input.add(Arrays.asList(new String[] {"AAA","JFK"}));
        input.add(Arrays.asList(new String[] {"JFK","BBB"}));
        input.add(Arrays.asList(new String[] {"JFK","CCC"}));
        input.add(Arrays.asList(new String[] {"CCC","JFK"}));
        // ["JFK","AAA","JFK","CCC","JFK","BBB"]


        findItinerary(input).forEach(s -> System.out.print(s + " "));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> path : tickets) {
            List<String> arrivals = graph.getOrDefault(path.get(0), new ArrayList<>());
            arrivals.add(path.get(1));
            graph.put(path.get(0), arrivals);
        }
        graph.keySet().forEach(k -> graph.get(k).sort(String::compareTo));
        dfs("JFK", graph);
        Collections.reverse(path);

        return path;
    }

    private void dfs(String location, Map<String, List<String>> graph) {
        List<String> arrivals = graph.get(location);

        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.remove(0), graph);
        }

        path.add(location);
    }
}
