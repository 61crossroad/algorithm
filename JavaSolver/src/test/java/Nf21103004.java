import org.junit.jupiter.api.Test;

public class Nf21103004 {

    @Test
    public void run() {
        System.out.println(
                solution(new int[][] {
                        {1, -7, -2, 1, -1},{2, 3, 0, -1, -2},{1, -1, 6, -1, -2},{-1, 1, -2, 0, 4},{-10, 5, -3, -1, 1}
                })
        );
    }

    public int solution(int[][] board) {
        int answer = 0;
        final int N = board.length;
        int[][] max = new int[N][N];
        int[][] min = new int[N][N];

        max[0][0] = min[0][0] = board[0][0];
        for (int i = 1; i < N; i++) {
            max[0][i] = min[0][i] = max[0][i - 1] + board[0][i];
            max[i][0] = min[i][0] = max[i - 1][0] + board[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (board[i][j] == 0) {
                    int[] val = getMaxAndMin(max[i - 1][j], min[i - 1][j], max[i][j - 1], min[i][j - 1]);
                    min[i][j] = Math.min(val[0], val[1] * -1);
                    max[i][j] = Math.max(val[1], val[0] * -1);
                } else {
                    int[] val = getMaxAndMin(max[i - 1][j], min[i - 1][j], max[i][j - 1], min[i][j - 1], board[i][j]);
                    min[i][j] = val[0];
                    max[i][j] = val[1];
                }
            }
        }

        answer = max[N - 1][N - 1];

        return answer;
    }

    private int[] getMaxAndMin(int a, int b, int c, int d, int e) {
        return getMaxAndMin(a + e, b + e, c + e, d + e);
    }

    private int[] getMaxAndMin(int a, int b, int c, int d) {
        int min = a;
        min = Math.min(min, b);
        min = Math.min(min, c);
        min = Math.min(min, d);

        int max = a;
        max = Math.max(max, b);
        max = Math.max(max, c);
        max = Math.max(max, d);

        return new int[] {min, max};
    }

}
