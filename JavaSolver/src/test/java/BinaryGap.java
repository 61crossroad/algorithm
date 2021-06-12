import org.junit.jupiter.api.Test;

public class BinaryGap {
    @Test
    public void run() {
        System.out.println(solution(1041));
    }

    private int solution(int N) {
        int answer = 0;

        for (int cur = -1, n = N ; 1 <= n; ) {
            int rm = n % 2;

            if (rm == 1) {
                if (answer < cur) {
                    answer = cur;
                }
                cur = 0;
            } else if (rm == 0 && -1 < cur) {
                cur++;
            }

            n /= 2;
        }

        return answer;
    }
}
