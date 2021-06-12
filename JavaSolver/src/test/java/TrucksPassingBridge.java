import org.junit.jupiter.api.Test;

import java.util.*;

// TODO!
public class TrucksPassingBridge {

    @Test
    public void run() {
        solution(2, 10, new int[] {7, 4, 5, 6});
    }

    private class Bridge {
        int time;
        int weight;
        List<Integer> ready;
        Map<Integer, Integer> pass;
        List<Integer> over;
    }

    private int solution(int bridge_length, int weight, int[] truck_weights) {
        // int answer = 0;
        int answer = Integer.MAX_VALUE;

        Queue<Bridge> queue = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            Bridge bridge = new Bridge();
            bridge.time = 1;
            bridge.ready = new ArrayList<>();
            bridge.over = new ArrayList<>();

            bridge.pass = new HashMap<>();
            bridge.pass.put(1, i);
            bridge.weight = weight - truck_weights[i];

            for (int j = 0; j < truck_weights.length; j++) {
                if (j != i) {
                    bridge.ready.add(truck_weights[j]);
                }
            }

            queue.add(bridge);
        }

        while (!queue.isEmpty()) {
            Bridge bridge = queue.poll();

            if (bridge.ready.isEmpty() && bridge.pass.isEmpty()) {
                if (bridge.time < answer) {
                    answer = bridge.time;
                }
            }

        }

        return answer;
    }
}
