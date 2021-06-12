import org.junit.jupiter.api.Test;

public class MaxProfit {

    @Test
    public void run() {
        System.out.println(
                solution(
                        // new int[] {23171, 21011, 21123, 21366, 21013, 21367}
                        new int [] {6, 5, 4, 3, 2, 1}
                )
        );
    }

    private int solution(int[] A) {
        if (A.length <= 1) {
            return 0;
        }

        int min = A[0];
        int p = 0;

        for (int i = 1; i < A.length; i++) {
            int cur = A[i] - min;
            if (p < cur) {
                p = cur;
            }

            if (A[i] < min) {
                min = A[i];
            }
        }

        return p;
    }
}
