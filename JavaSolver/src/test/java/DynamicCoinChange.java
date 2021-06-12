import org.junit.jupiter.api.Test;

public class DynamicCoinChange {

    @Test
    public void run() {
        System.out.println(solution(
                new int[] {1, 3, 4},
                6
        ));
    }
    private int solution(int[] coins, int money) {
        int[][] dp = new int[coins.length + 1][money + 1];

        for (int i = 1; i <= money; i++) dp[0][i] = Integer.MAX_VALUE;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j < coins[i - 1]; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            for (int j = coins[i - 1]; j <= money; j++) {
                int fromSameCoin = dp[i][j - coins[i - 1]] + 1;
                int fromPrevCoin = dp[i - 1][j];
                dp[i][j] = fromSameCoin < fromPrevCoin ? fromSameCoin : fromPrevCoin;
            }
        }

        return dp[coins.length][money];
    }
}
