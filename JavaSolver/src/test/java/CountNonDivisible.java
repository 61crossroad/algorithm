import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNonDivisible {

    @Test
    public void run() {
        int[] answer = solution(
                new int[] {1, 2, 3, 4, 6, 7, 12}
                // new int[] {2, 4}
                // new int[] {3, 1, 2, 3, 6}
        );
        Arrays.stream(answer).forEach(a -> System.out.print(a + " "));
    }

    private int[] solution(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();

        int[] F = new int[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (F[i] == 0) {
                for (int k = i * i; k <= max; k += i) {
                    if (F[k] == 0) {
                        F[k] = i;
                    }
                }
            }
        }

        int[] in = new int[max + 1];
        Arrays.stream(A).forEach(a -> in[a]++);

        int[] answer = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int cnt = A.length - in[1];
            int x = A[i];

            if (x != 1 && F[x] == 0) {
                cnt -= in[x];
            } else if (0 < F[x]){
                Map<Integer, Integer> check = new HashMap<>();
                for (; 0 < F[x] ; x /= F[x]) {
                    check.put(x, 1);
                    check.put(F[x], 1);
                }
                check.put(x, 1);
                for (Integer key : check.keySet()) {
                    cnt -= in[key];
                }
            }

            answer[i] = cnt;
        }

        return answer;
    }
}
