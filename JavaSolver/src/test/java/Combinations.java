import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Combinations {

    private final List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(new ArrayList<>(), 1, n, k);

        return results;
    }

    private void dfs(List<Integer> elements, Integer start, Integer n, Integer k) {
        if (k == 0) {
            results.add(new ArrayList<>(elements));
        } else {
            for (int i = start; i <= n; i++) {
                elements.add(i);
                dfs(elements, i + 1, n, k - 1);
                elements.remove(elements.size() - 1);
            }
        }
    }

    @Test
    public void run() {
        List<List<Integer>> output = combine(4, 2);
        output.forEach(comb -> System.out.println(
                comb.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))));
    }
}
