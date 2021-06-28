import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    private Map<Integer, Integer> dp = new HashMap<>();

    public int fibMem(int n) {
        if (n <= 1) {
            return n;
        } else if (dp.get(n) != null) {
            return dp.get(n);
        } else {
            Integer sum = fibMem(n - 1) + fibMem(n - 2);
            dp.put(n, sum);
            return sum;
        }
    }

    public int fibTab(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);

        for (int i = 2; i <= n; i++) {
            dp.put(i, dp.get(i - 1) + dp.get(i - 2));
        }

        return dp.get(n);
    }

    @Test
    public void run() {
        System.out.println(fibTab(6));
    }
}
