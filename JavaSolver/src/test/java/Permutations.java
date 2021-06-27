import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Permutations {
    private final List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(elements, new ArrayList<>());

        return results;
    }

    private void dfs(List<Integer> elements, List<Integer> perm) {
        if (elements == null || elements.isEmpty()) {
            results.add(
                    new ArrayList<>(perm));
        } else {
            for (Integer e : elements) {
                List<Integer> nextElements = 
                    elements.stream()
                        .filter(el -> !el.equals(e))
                        .collect(Collectors.toList());
                
                perm.add(e);
                dfs(nextElements, perm);
                perm.remove(e);
            }
        }
    }
    
    @Test
    public void run() {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> output = permute(nums);
        output.forEach(perm -> System.out.println(
            perm.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))));
    }
}
