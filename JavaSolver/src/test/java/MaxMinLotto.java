import org.junit.jupiter.api.Test;

public class MaxMinLotto {
    @Test
    public void run() {
        int[] result = solution(
                new int[] {44, 1, 0, 0, 31, 25},
                new int[] {31, 10, 45, 1, 6, 19});
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zeros = 0;

        for (int num : lottos) {
            if (num == 0) {
                zeros++;
                continue;
            }

            for (int win : win_nums) {
                if (num == win) {
                    count++;
                    break;
                }
            }
        }

        return new int[] {Math.min(7 - count - zeros, 6), Math.min(7 - count, 6)};
    }
}
