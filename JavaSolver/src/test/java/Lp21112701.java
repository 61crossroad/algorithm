import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lp21112701 {

    @Test
    public void run() {
        int[] a = solution(new String[] {
//                "P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"
                "P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"
        });
        System.out.println(a[0] + " " + a[1]);
    }

    public int[] solution(String[] record) {
        int[] answer = {0, 0};
        List<String[]> records = Stream.of(record).map(r -> r.split("\\s+")).collect(Collectors.toList());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < Integer.parseInt(records.get(0)[2]); i++) {
            Integer amount = Integer.parseInt(records.get(0)[1]);
            queue.add(amount);
            stack.add(amount);
        }

        for (int i = 1; i < records.size(); i++) {
            String[] cur = records.get(i);
            Integer amount = Integer.parseInt(cur[1]);
            int quantity = Integer.parseInt(cur[2]);

            if ("P".equals(cur[0])) {
                for (int j = 0; j < quantity; j++) {
                    queue.add(amount);
                    stack.add(amount);
                }
            } else {
                for (int j = 0; j < quantity; j++) {
                    answer[0] += queue.poll();
                    answer[1] += stack.pop();
                }
            }
        }

        return answer;
    }

}
