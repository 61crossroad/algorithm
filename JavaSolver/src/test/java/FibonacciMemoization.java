import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {

    @Test
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.print(fib(i, new HashMap<>()) + " ");
        }
    }

    private int fib(int n, Map<Integer, Integer> dp) {
        if (n <= 1) {
            return n;
        }

        Integer val = dp.getOrDefault(n, null);
        if (val != null) {
            return val;
        }

        dp.put(n, fib(n - 1, dp) + fib(n - 2, dp));
        return dp.get(n);
    }

}
