import org.junit.jupiter.api.Test;

public class Hanoi {

    @Test
    public void run() {
        hanoi(3, "A", "B", "C");
    }

    private void hanoi(int n, String a, String b, String c) {
        if (n < 1) return;
        hanoi(n - 1, a, c, b);
        print(n + ": " + a + " -> " + c);
        hanoi(n - 1, b, a, c);
    }

    private void print(String str) {
        System.out.println(str);
    }
}
