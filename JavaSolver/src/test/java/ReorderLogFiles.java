import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReorderLogFiles {

    @Test
    public void run() {
        String[] input = new String[] {
                "dig1 8 1 5 1",
                "let1 art can",
                "let9 art zero",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };
        Stream.of(solutionLambda(input)).forEach(System.out::println);
        Stream.of(solution(input)).forEach(System.out::println);
    }

    private String[] solutionLambda(String[] input) {
        String num = "^[0-9\\s]*$";

        Map<String, List<String>> map = Stream.of(input)
                .collect(Collectors.groupingBy(w -> {
                    String[] arr = w.split("\\s+");

                    if (Pattern.matches(num, arr[1])) {
                        return "num";
                    } else {
                        return "al";
                    }
                }));

        List<String> sorted = map.get("al").stream().sorted((o1, o2) -> {
            String s1 = o1.substring(o1.indexOf(" "));
            String s2 = o2.substring(o2.indexOf(" "));

            if (s1.compareTo(s2) == 0) {
                return o1.substring(0, o1.indexOf(" ")).compareTo(o2.substring(0, o2.indexOf(" ")));
            }

            return s1.compareTo(s2);
        }).collect(Collectors.toList());

        List<String> result = Stream
                .concat(sorted.stream(), map.get("num").stream())
                .collect(Collectors.toList());

        return result.toArray(new String[]{});

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
