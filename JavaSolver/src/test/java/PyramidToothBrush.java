import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PyramidToothBrush {
    @Test
    public void run() {
        int[] ans = solution(
                new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[] {"young", "john", "tod", "emily", "mary"},
                new int[] {12, 4, 2, 5, 10}
        );
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> adj = new HashMap<>();
        Map<String, Integer> benefits = new LinkedHashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            adj.put(enroll[i], referral[i]);
            benefits.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String person = seller[i];
            int benefit = amount[i] * 100;

            while (!"-".equals(person) && benefit > 0) {
                int tenth = benefit / 10;
                benefit = benefit - tenth;
                benefits.put(person, benefits.get(person) + benefit);
                benefit = tenth;
                person = adj.get(person);
            }
        }

        return benefits.values().stream().mapToInt(i -> i).toArray();
    }
}
