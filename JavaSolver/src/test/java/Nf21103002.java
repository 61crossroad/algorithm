import org.junit.jupiter.api.Test;

public class Nf21103002 {

    @Test
    public void run() {
        int[] a = solution(3, 4);
        System.out.println(a[0] + " " + a[1]);
    }

    public int[] solution(int n, int jump) {
        int[] answer = {};
        int[][] m = new int[n][n];
        int dir, y, x, lastY, lastX;
        dir = y = x = 0;

        if (n % 2 == 0) {
            lastY = n / 2;
            lastX = lastY - 1;
        } else {
            lastY = lastX = n / 2;
        }

        for (int val = 1; val <= n * n; ) {
            m[y][x] = val++;

            for (int count = jump; count > 0 && val <= n * n; ) {
                int[] loc = move(y, x, dir, lastY, lastX, n);
                y = loc[0];
                x = loc[1];
                dir = loc[2];
                if (m[y][x] == 0) {
                    count--;
                }
            }
        }

        answer = new int[] {y + 1, x + 1};

        return answer;
    }

    private int[] move(int y, int x, int dir, int lastY, int lastX, int n) {
        if (y == lastY && x == lastX) {
            return new int[] {0, 0, 0};
        }

        if (dir == 0) {
            if (x + 1 > n - y - 1) {
                y++;
                dir = 1;
            } else {
                x++;
            }
        } else if (dir == 1) {
            if (y + 1 > x) {
                x--;
                dir = 2;
            } else {
                y++;
            }
        } else if (dir == 2) {
            if (x - 1 < n - y - 1) {
                y--;
                dir = 3;
            } else {
                x--;
            }
        } else {
            if (y - 1 < x + 1) {
                x++;
                dir = 0;
            } else {
                y--;
            }
        }

        return new int[] {y, x, dir};
    }

}
