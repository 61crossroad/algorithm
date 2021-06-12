import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Hotter {

    @Test
    public void run() {
        System.out.println(
                solution(
                        new int[] {1, 2, 3, 9, 10, 12},
                        7));
    }

    private int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int s : scoville) {
            pQueue.add(s);
        }

        while (!pQueue.isEmpty() && pQueue.peek() < K) {
            int min = pQueue.poll();
            int subMin;

            if (pQueue.isEmpty()) {
                answer = -1;
                break;
            }

            subMin = pQueue.poll();
            pQueue.add(min + subMin * 2);
            answer++;
        }

        return answer;
    }
}
