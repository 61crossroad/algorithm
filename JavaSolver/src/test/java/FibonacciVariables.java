import org.junit.jupiter.api.Test;

public class FibonacciVariables {

    @Test
    public void run() {
        int n = 10;
        int x = 0;
        for (int i = 0, y = 1, t; i < n; i++) {
            t = x + y;
            x = y;
            y = t;
        }
        System.out.println(x);
    }
}
