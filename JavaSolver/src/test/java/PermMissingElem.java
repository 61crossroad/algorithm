import org.junit.jupiter.api.Test;

public class PermMissingElem {

    @Test
    public void run() {
        System.out.println(solution(new int[] {2, 3, 1, 5}));
    }

    private int solution(int[] A) {
        long answer = ((long) (A.length + 1)) * ((long) (A.length + 2)) / 2;

        for (int a : A) {
            answer -= a;
        }

        return (int) answer;
    }
}
