import org.junit.jupiter.api.Test;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    @Test
    public void run() {
//        String input = "23";
        String input = "";
        List<String> answer = letterCombinations(input);
        answer.forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {
        Map<String, List<String>> map = init();

        String[] arr = digits.split("");
        List<String> answer = new ArrayList<>();
        dfs(0, arr, map, new StringBuilder(), answer);

        return answer;
    }

    private void dfs(int index, String[] arr, Map<String, List<String >> map, StringBuilder sb, List<String> answer) {
        if (index >= arr.length) {
            answer.add(sb.toString());
        } else if (map.get(arr[index]) != null) {
            map.get(arr[index]).forEach(ch -> {
                sb.append(ch);
                dfs(index + 1, arr, map, sb, answer);
                sb.delete(sb.length() - 1, sb.length());
            });
        }
    }

    private Map<String, List<String>> init() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList(new String[] {"a", "b", "c"}));
        map.put("3", Arrays.asList(new String[] {"d", "e", "f"}));
        map.put("4", Arrays.asList(new String[] {"g", "h", "i"}));
        map.put("5", Arrays.asList(new String[] {"j", "k", "l"}));
        map.put("6", Arrays.asList(new String[] {"m", "n", "o"}));
        map.put("7", Arrays.asList(new String[] {"p", "q", "r", "s"}));
        map.put("8", Arrays.asList(new String[] {"t", "u", "v"}));
        map.put("9", Arrays.asList(new String[] {"w", "x", "y", "z"}));

        return map;
    }
}
