import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
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

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(
            sol.solution(
                new int[] {1, 2, 3, 9, 10, 12},
                7)
        );
    }
}
