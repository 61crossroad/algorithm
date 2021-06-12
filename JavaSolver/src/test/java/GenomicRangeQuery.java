import org.junit.jupiter.api.Test;

public class GenomicRangeQuery {

    @Test
    public void run() {
        int[] answer = solution(
                "CAGCCTA",
                new int[] {2, 5, 0},
                new int[] {4, 5, 6}
        );

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    private int[] solution(String S, int[] P, int[] Q) {
        int[][] sum = new int[S.length()][4];
        for (int i = 0; i < S.length(); i++) {
            if (0 < i) {
                System.arraycopy(sum[i - 1], 0, sum[i], 0, 4);
            } else {
                sum[i][0] = sum[i][1] = sum[i][2] = sum[i][3] = 0;
            }

            switch (S.substring(i, i + 1)) {
                case "A" : sum[i][0]++; break;
                case "C" : sum[i][1]++; break;
                case "G" : sum[i][2]++; break;
                default: sum[i][3]++; break;
            }
        }

        int[] answer = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < 4; j++) {
                int sub;
                if (P[i] == 0) {
                    sub = 0;
                } else {
                    sub = sum[P[i] - 1][j];
                }
                if (0 < sum[Q[i]][j] - sub) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
