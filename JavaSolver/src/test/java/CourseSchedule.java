import org.junit.jupiter.api.Test;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] dependency : prerequisites) {
            List<Integer> pres = graph.getOrDefault(dependency[0], new ArrayList<>());
            pres.add(dependency[1]);
            graph.put(dependency[0], pres);
        }

        Set<Integer> visited = new HashSet<>();
        for (Integer course : graph.keySet()) {
            if (!dfs(course, graph, new HashSet<>(), visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Integer course, Map<Integer, List<Integer>> graph, Set<Integer> traced, Set<Integer> visited) {
        if (traced.contains(course)) {
            return false;
        } else if (visited.contains(course)) {
            return true;
        } else {
            traced.add(course);

            List<Integer> preGraph = graph.get(course) == null ? Collections.EMPTY_LIST : graph.get(course);
            for (Integer preCourse : preGraph) {
                if (!dfs(preCourse, graph, traced, visited)) {
                    return false;
                }
            }

            traced.remove(course);
            visited.add(course);

            return true;
        }
    }

    @Test
    public void run() {
        int numCourses = 2;
        int[][] prerequisites = new int[][] {
                // {1, 0},
                {0, 1}
        };

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
