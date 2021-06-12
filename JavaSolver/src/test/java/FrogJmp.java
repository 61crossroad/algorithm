import org.junit.jupiter.api.Test;

public class FrogJmp {

    @Test
    public void run() {
        System.out.println(solution(1, 1000000000, 100));
    }

    public int solution(int X, int Y, int D) {
        int rm = (Y - X) % D;
        return rm != 0 ? (Y - X) / D + 1 : (Y - X) / D;
    }
}
