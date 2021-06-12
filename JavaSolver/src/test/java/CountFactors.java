import org.junit.jupiter.api.Test;

public class CountFactors {

    @Test
    public void run() {
        System.out.println(solution(2147483647));
    }

    private int solution(int N) {
        int cnt = 0;
        int i;
        for (i = 1; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                cnt += 2;
            }
        }
        if (i * i == N) {
            cnt++;
        }

        return cnt;
    }
}
