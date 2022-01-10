import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class WordConversion {
    @Test
    public void run() {
        System.out.println(solution(
                "hit",
                "cog",
//                new String[] {"hot", "dot", "dog", "lot", "log", "cog"}
                new String[] {"hot", "dot", "dog", "lot", "log"}
        ));
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Map<String, List<String>> adj = new HashMap<>();

        List<String> fromBegin = new ArrayList<>();
        boolean isValid = false;
        for (String word : words) {
            if (word.equals(target)) {
                isValid = true;
            }

            if (getDifference(begin, word) == 1) {
                fromBegin.add(word);
            }

            List<String> next = Arrays.stream(words)
                    .filter(w -> getDifference(word, w) == 1)
                    .collect(Collectors.toList());
            adj.put(word, next);
        }

        if (!isValid) {
            return 0;
        }

        adj.put(begin, fromBegin);

        Queue<Conversion> queue = new LinkedList<>();
        queue.add(new Conversion(begin, 0));

        while (!queue.isEmpty()) {
            Conversion conv = queue.poll();
            if (conv.word.equals(target)) {
                answer = conv.count;
                break;
            }

            List<String> next = adj.get(conv.word);
            for (String word : next) {
                queue.add(new Conversion(word, conv.count + 1));
            }
        }

        return answer;
    }

    private int getDifference(String s1, String s2) {
        int count = 0;

        for (int i = 0; i < s1.length() && count < 2; i++) {
            if (!s1.substring(i, i + 1).equals(s2.substring(i, i + 1))) {
                count++;
            }
        }

        return count;
    }

    private static class Conversion {
        String word;
        int count;

        Conversion(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
