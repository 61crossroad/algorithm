import org.junit.jupiter.api.Test;

import java.util.*;

public class Nf21103001 {

    @Test
    public void run() {
        String[] id_list = new String[] {
                "JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"
        };
        int k = 3;
        System.out.println(
                solution(id_list, k));
    }

    public int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> counts = new HashMap<>();
        Set<String> dailyIds = new HashSet<>();

        for (String idsStr : id_list) {
            String[] ids = idsStr.split(" ");
            dailyIds.clear();
            dailyIds.addAll(Arrays.asList(ids));
            for (String id : dailyIds) {
                Integer count = counts.getOrDefault(id, 0);
                if (count < k) {
                    counts.put(id, count + 1);
                }
            }
        }

        for (Integer count : counts.values()) {
            answer += count;
        }

        return answer;
    }

}
