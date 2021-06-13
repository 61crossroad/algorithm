import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PermCheck {

    @Test
    public void run() {
        /* int[] in = new int[100000];
        for (int i = 0; i < 100000; i++) {
            in[i] = (int) (Math.random() * 1000000000.0);
        } */
        int[] in = new int[] {3};

        System.out.println(
                solution(in)
        );
    }

    private int solution(int[] A) {
        Arrays.sort(A);
        // int n = A[A.length - 1];

        if (A[0] != 1) {
            return 0;
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i + 1]) {
                return 0;
            }
        }

        return 1;
    }
}
