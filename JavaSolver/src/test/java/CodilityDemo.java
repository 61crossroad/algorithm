import java.util.Arrays;

public class CodilityDemo {
    private int solution(int[] A) {
        Arrays.sort(A);
        int answer = A[A.length - 1] + 1;

        for (int i = 1; i < A.length; i++) {
            int target = A[i - 1] + 1;
            if (target != A[i] && 0 < target) {
                answer = target;
            }
        }

        if (answer <= 0) {
            answer = 1;
        }

        return answer;
    }
}
