import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MinimumWindowSubstring {

    @Test
    public void run() {
//        String s =  "ADOBECODEBANC";
//        String t = "ABC";
//        String s = "a";
//        String t = "aa";
        String s = "ab";
        String t = "b";
        System.out.println(minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Map<String, Integer> need = new HashMap<>();
        Stream.of(t.split(""))
                .forEach(ch -> need.put(ch, need.getOrDefault(ch, 0) + 1));

        int min = s.length() + 1;
        String answer = "";

        Map<String, Integer> count = new HashMap<>();
        String[] arr = s.split("");
        int left = -1;
        for (int right = 0; right < arr.length; right++) {
            if (need.get(arr[right]) != null) {
                count.put(arr[right], count.getOrDefault(arr[right], 0) + 1);
                if (left < 0) {
                    left = right;
                }

                int i = left;
                while (i < right) {
                    Integer needed = need.get(arr[i]);
                    Integer cur = count.get(arr[i]);

                    if (needed != null) {
                        if (cur - 1 >= needed) {
                            count.put(arr[i], cur - 1);
                            int j = i + 1;
                            for (; need.get(arr[j]) == null && j < right; j++);
                            left = i = j;
                            continue;
                        } else {
                            break;
                        }
                    }

                    i++;
                }

                boolean invalid = need.entrySet().stream()
                        .anyMatch(e -> count.get(e.getKey()) == null ? true : e.getValue() > count.get(e.getKey()));

                if (!invalid && min > right - left + 1) {
                    min = right - left + 1;
                    answer = s.substring(left, right + 1);
                }
            }
        }

        return answer;
    }
}
