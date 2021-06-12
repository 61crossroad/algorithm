import org.junit.jupiter.api.Test;

public class TapeEquilibrium {

    @Test
    public void run() {
        System.out.println(solution(new int[] {3, 1, 2, 4, 3}));
    }

    private int solution(int[] A) {
        int answer = Integer.MAX_VALUE;
        int[] sumAsc = new int[A.length];
        int[] sumDesc = new int[A.length];

        sumAsc[0] = A[0];
        sumDesc[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            sumAsc[i] = sumAsc[i - 1] + A[i];
            sumDesc[A.length - i - 1] = sumDesc[A.length - i] + A[A.length - i - 1];
        }

        for (int i = 1; i < A.length; i++) {
            int dif = Math.abs(sumAsc[i - 1] - sumDesc[i]);
            if (dif < answer) {
                answer = dif;
            }
        }

        return answer;
    }
}
