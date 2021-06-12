import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {

    @Test
    public void run() {
        String[] input = new String[] {
                "eat", "tea", "tan", "ate", "nat", "bat"};
        solution(input);
    }

    private void solution(String[] input) {
        Map<String, List<String>> map = Stream.of(input)
                .collect(Collectors.groupingBy(
                        s -> Stream.of(s.split(""))
                                .sorted(Comparator.naturalOrder())
                                .collect(Collectors.joining())
                        ));
        map.forEach((k, v) -> System.out.println(String.join(", ", v)));
    }
}
