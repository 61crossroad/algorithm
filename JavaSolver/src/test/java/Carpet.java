import org.junit.jupiter.api.Test;

public class Carpet {

    @Test
    public void run() {
        int[] sol = solution(24, 24);
        System.out.println(sol[0] + " " + sol[1]);
    }

    private static int[] solution(int brown, int yellow) {
        int[] answer = {};

        int x;
        for (x = brown / 2 - 2; 0 < x; x--) {
            if (yellow % x != 0) continue;
            int eval = x + (yellow / x) - (brown - 4) / 2;
            if (eval != 0) continue;
            if (yellow % x != 0) continue;
            break;
        }
        int[] result = new int[] {x + 2, yellow / x + 2};
        answer = result;
        return answer;
    }
}
