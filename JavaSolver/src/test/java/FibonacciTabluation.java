import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FibonacciTabluation {

    @Test
    public void run() {
        int n = 10;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        for (int i = 2; i <= n; i++) {
            dp.put(i, dp.get(i - 1) + dp.get(i - 2));
        }
        System.out.println(dp.get(n));
    }
}
