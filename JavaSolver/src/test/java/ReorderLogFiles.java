import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReorderLogFiles {

    @Test
    public void run() {
        String[] result = solution(new String[] {
                "dig1 8 1 5 1",
                "let1 art can",
                "let9 art zero",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"});

        Arrays.stream(result).forEach(System.out::println);
    }

    private String[] solution(String[] input) {
        String al = "^[a-zA-Z\\s]*$";
        String num = "^[0-9\\s]*$";

        List<String> sorted = Arrays.stream(input).sorted((s1, s2) -> {
            String log1 = s1.substring(s1.indexOf(" "));
            String log2 = s2.substring(s2.indexOf(" "));

            if (Pattern.matches(num, log1) && Pattern.matches(num, log2)) {
                return 0;
            } else if (Pattern.matches(al, log1) && Pattern.matches(num, log2)) {
                return -1;
            } else if (Pattern.matches(num, log1) && Pattern.matches(al, log2)) {
                return 1;
            } else if (log1.compareTo(log2) == 0) {
                return s1.substring(0, s1.indexOf(" ")).compareTo(
                        s2.substring(0, s2.indexOf(" ")));
            } else {
                return log1.compareTo(log2);
            }
        }).collect(Collectors.toList());

        return sorted.toArray(new String[] {});
    }
}
