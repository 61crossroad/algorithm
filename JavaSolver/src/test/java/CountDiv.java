import org.junit.jupiter.api.Test;

public class CountDiv {

    @Test
    public void run() {
        System.out.println(
                solution(6, 11, 2));
    }

    private int solution(int A, int B, int K) {
        int start = A % K == 0 ? A / K : A / K + 1;
        int end = B / K;

        return end - start + 1;
    }
}
