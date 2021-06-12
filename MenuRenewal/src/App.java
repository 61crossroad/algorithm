import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        Map<String, Integer> resultMap = new HashMap<>();

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < orders.length; i++) {
            String[] order = orders[i].split("");
            Arrays.sort(order);

            queue.clear();
            for (String o : order) {
                queue.add(o);
            }

            while (!queue.isEmpty()) {
                String cur = queue.poll();

                for (int c : course) {
                    if (cur.length() == c) {
                        // System.out.println(cur);
                        Integer cnt = resultMap.getOrDefault(cur, 0);
                        resultMap.put(cur, ++cnt);
                        break;
                    }
                }

                int index;
                for (index = 0; index < order.length && !order[index].equals(cur); index++);
                for (index += 1 ; index < order.length; index++) {
                    System.out.println(cur + order[index]);
                    queue.add(cur + order[index]);
                }
            }
        }

        List<String> result = new ArrayList<>();
        
        Iterator<String> it = resultMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (1 < resultMap.get(key)) {
                result.add(key);
            }
        }

        result.toArray(answer);

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        String[] a = s.solution(
            new String[] {
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
            },
            new int[] {2, 3, 4}
        );

        for (String ans : a) {
            System.out.println(ans);
        }
    }
}
