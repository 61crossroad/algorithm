import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MostCommonWord {

    @Test
    public void run() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit by bAll.";
        String[] banned = new String[] {"hit"};

        System.out.println(solution(paragraph, banned));
    }

    private String solution(String para, String[] banned) {
        String filtered = para.replaceAll("[^a-zA-Z\\s]", "");
        String[] words = filtered.split(" ");
        boolean[] checked = new boolean[words.length];

        int max = 0;
        String maxWord = "";
        for (int i = 0; i < words.length; i++) {
            if (checked[i]) {
                continue;
            }

            boolean isBanned = false;
            for (String ban : banned) {
                if (ban.equals(words[i])) {
                    isBanned = true;
                    break;
                }
            }

            if (!isBanned) {
                checked[i] = true;
                int count = 0;
                for (String word : words) {
                    if (words[i].equals(word.toLowerCase())) {
                        count++;
                    }
                }

                if (max < count) {
                    max = count;
                    maxWord = words[i];
                }
            }
        }

        return maxWord;
    }
}
