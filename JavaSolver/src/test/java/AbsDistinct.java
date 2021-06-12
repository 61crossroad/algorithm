import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AbsDistinct {

    @Test
    public void run() {
        System.out.println(solution(
                // new int[] {-1, -1, -1, 0, 0, 1, 1, 2, 2, 2}
                // new int[] {-5, -3, -1, 0, 3, 6}
                // new int[] {-2147483648, -1, 0, 1}
                new int[] {-1, 1}));
    }

    private int solution(int[] A) {
        List<Integer> dt = new ArrayList<>();
        int index = 0;
        while (index < A.length) {
            int sub;
            for (sub = index + 1; sub < A.length && A[index] == A[sub]; sub++);
            dt.add(A[index]);
            index = sub;
        }

        int head = dt.size() - 1;
        int tail = 0;
        int cnt = 0;

        while (tail < head) {
            long tailV = Math.abs((long) dt.get(tail));
            long headV = Math.abs((long) dt.get(head));

            if (tailV > headV) {
                tail++;
            } else if (tailV < headV) {
                head--;
            } else {
                head--;
                tail++;
            }
            cnt++;
        }

        if (tail == head) {
            return cnt + 1;
        } else {
            return cnt;
        }
    }
}
