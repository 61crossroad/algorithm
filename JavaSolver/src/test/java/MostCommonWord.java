import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MostCommonWord {

    @Test
    public void run() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit by bAll.";
        String[] banned = new String[] {"hit"};

        System.out.println(solution(paragraph, banned));
    }

    private String solution(String para, String[] banned) {
        String filtered = para.replaceAll("[^\\w\\s]", "").toLowerCase();
        List<String> list = Arrays.stream(filtered.split(" "))
                .filter(w -> {
                    for(String ban : banned) {
                        if (w.equals(ban)) {
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());

        Map<String, Integer> counts = new HashMap<>();

        list.forEach(w -> {
            int count = counts.getOrDefault(w, 0);
            count++;
            counts.put(w, count);
        });

        return Collections
                .max(counts.entrySet(), Comparator.comparingInt(Map.Entry::getValue))
                .getKey();
    }
}
