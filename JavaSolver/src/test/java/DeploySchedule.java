import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DeploySchedule {
    @Test
    public void run() {
        int[] answer = solution(
                new int[] {93, 30, 55},
                new int[] {1, 30, 5});

        for (int j : answer) {
            System.out.print(j + " ");
        }
    }

    private int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            double remain = 100 - progresses[i];
            int day = (int) Math.ceil(remain / speeds[i]);
            list.add(day);
        }

        List<Integer> result = new ArrayList<>();
        while (!list.isEmpty()) {
            int cur = list.remove(0);
            int cnt = 1;

            while (!list.isEmpty() && list.get(0) <= cur) {
                list.remove(0);
                cnt++;
            }

            result.add(cnt);
        }

        answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
