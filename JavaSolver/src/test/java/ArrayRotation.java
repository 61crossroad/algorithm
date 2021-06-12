import org.junit.jupiter.api.Test;

public class ArrayRotation {

    @Test
    public void run() {
        int[] ans = solution(
                new int[] {3, 8, 9, 7, 6},
                3
//                 new int[] {0, 0, 0},
//                new int[] {},
//                1
        );

        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    private int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return A;
        }

        int[] answer = new int[A.length];
        int offset = K % A.length;

        for (int i = 0; i < A.length; i++) {
            int index = i + offset;

            if (A.length <= index) {
                index -= A.length;
            }

            answer[index] = A[i];
        }

        return answer;
    }
}
