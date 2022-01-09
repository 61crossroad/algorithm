import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    @Test
    public void run() {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    private int characterReplacement(String s, int k) {
        String[] sArr = s.split("");
        Map<String, Integer> counts = new HashMap<>();
        int left, right;
        left = right =0;

        for (; right < sArr.length; right++) {
            counts.put(sArr[right], counts.getOrDefault(sArr[right], 0) + 1);
            int max = 0;

            for (Integer count : counts.values()) {
                max = Math.max(max, count);
            }

            if (right - left + 1 - max > k) {
                counts.put(sArr[left], counts.get(sArr[left]) - 1);
                left++;
            }
        }

        return right - left;
    }
}
