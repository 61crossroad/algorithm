import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringAlt {

    @Test
    public void run() {
        System.out.println(minWindow("a", "aa"));
    }

    private String minWindow(String s, String t) {
        Map<String, Integer> counts = new HashMap<>();
        String[] sArr = s.split("");
        String[] tArr = t.split("");
        int missing = tArr.length, min = sArr.length + 1;
        String answer = "";

        for (String str : tArr) {
            counts.put(str, counts.getOrDefault(str, 0) + 1);
        }
        for (int count, left = 0, right = 0; right < sArr.length; right++) {
            count = counts.getOrDefault(sArr[right], 0);
            missing = count > 0 ? missing - 1 : missing;
            counts.put(sArr[right], count - 1);

            if (missing == 0) {
                while ((count = counts.get(sArr[left])) < 0) {
                    counts.put(sArr[left], count + 1);
                    left++;
                }

                if (right - left + 1 < min) {
                    min = right - left + 1;
                    answer = s.substring(left, right + 1);
                }

                counts.put(sArr[left], counts.get(sArr[left]) + 1);
                left++;
                missing++;
            }
        }

        return answer;
    }
}
