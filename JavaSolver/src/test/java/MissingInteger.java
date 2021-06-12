import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MissingInteger {

    @Test
    public void run() {
        /* int[] input = new int[100000];
        for (int i = 0; i < 100000; i++) {
            input[i] = (int) (Math.random() * 1000000);
        } */
        int[] input = new int[] {1, 3, 6, 4, 1, 2};

        long sTime = System.currentTimeMillis();
        System.out.println(
                solution(input)
        );
        long eTime = System.currentTimeMillis();

        System.out.println("\n" + (eTime - sTime) / 1000.0);
    }

    private int solution(int[] A) {
        int answer = 1;

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (0 < A[i]) {
                if (A[i] == answer) {
                    answer++;
                } else if (A[i] > answer) {
                    break;
                }
            }
        }

        return answer;
    }
}
