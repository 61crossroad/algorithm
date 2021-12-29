import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lp21112703 {

    @Test
    public void run() {
        int[] a = solution(50, 2500);
        System.out.println(a[0] + " " + a[1]);
    }

    public int[] solution(int n, int k) {
        int[] answer = {};
        int[][] seats = new int[n + 1][n + 1];
        List<int[]> pos = new ArrayList<>();
        seats[1][1] = 1;
        pos.add(new int[] {0, 0});
        pos.add(new int[] {1, 1});

        for (int i = 2; i <= k; i++) {
            int max = Integer.MIN_VALUE;
            int[] maxPos = new int[2];

            for (int y = 1; y <= n; y++) {
                for (int x = 1; x <= n; x++) {
                    if (seats[y][x] == 0) {
                        int min = Integer.MAX_VALUE;

                        for (int j = 1; j <pos.size(); j++) {
                            int y0 = pos.get(j)[0];
                            int x0 = pos.get(j)[1];
                            int len = Math.abs(y - y0) + Math.abs(x - x0);
                            if (min > len) {
                                min = len;
                            }
                        }

                        if (max < min) {
                            max = min;
                            maxPos[0] = y;
                            maxPos[1] = x;
                        } else if (max == min && maxPos[1] > x) {
                            maxPos[0] = y;
                            maxPos[1] = x;
                        } else if (max == min && maxPos[1] == x && maxPos[0] > y) {
                            maxPos[0] = y;
                        }
                    }
                }
            }

            seats[maxPos[0]][maxPos[1]] = i;
            pos.add(maxPos);
        }
        answer = pos.get(k);
        return answer;
    }

}
