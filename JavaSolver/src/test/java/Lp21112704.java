import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Lp21112704 {

    @Test
    public void run() {
        int[][] input =
                {{0,2,1,3},{1,2,2,5},{3,3,4,4},{4,1,6,3},{1,6,5,7},{5,5,7,6},{5,8,6,10}};
        String[] a = solution(input);
    }

    public String[] solution(int[][] rectangles) {
        String[] answer = {};
        int[][] recs = new int[rectangles.length][5];
        int[][] y = new int[1000001][2];
        int[][] x = new int[1000001][2];

        for (int i = 0; i < rectangles.length; i++) {
            recs[i][0] = rectangles[i][0];
            recs[i][1] = rectangles[i][1];
            recs[i][2] = rectangles[i][2];
            recs[i][3] = rectangles[i][3];
            recs[i][4] = i;
        }

        for (int i = 0; i < 1000001; i++) {
            y[i][0] = y[i][1] = x[i][0] = x[i][1] = Integer.MIN_VALUE;
        }

        Arrays.sort(recs, Comparator.comparingInt(o -> o[1]));

        for (int[] rec : recs) {
            int max = Math.max(0, y[rec[0]][0]);
            max = Math.max(max, y[rec[2]][1]);
            for (int i = rec[0] + 1; i < rec[2]; i++) {
                max = Math.max(max, y[i][0]);
                max = Math.max(max, y[i][1]);
            }
            int height = rec[3] - rec[1];
            rec[1] = max;
            rec[3] = rec[1] + height;
            y[rec[0]][0] = Math.max(y[rec[0]][0], rec[3]);
            y[rec[2]][1] = Math.max(y[rec[2]][1], rec[3]);
        }

        Arrays.sort(recs, Comparator.comparingInt(o -> o[0]));

        for (int[] rec : recs) {
            int max = Math.max(0, x[rec[1]][0]);
            max = Math.max(max, x[rec[3]][1]);
            for (int i = rec[1] + 1; i < rec[3]; i++) {
                max = Math.max(max, x[i][0]);
                max = Math.max(max, x[i][1]);
            }
            int width = rec[2] - rec[0];
            rec[0] = max;
            rec[2] = rec[0] + width;
            x[rec[1]][0] = Math.max(x[rec[1]][0], rec[2]);
            x[rec[3]][1] = Math.max(x[rec[3]][1], rec[2]);
        }

        Arrays.sort(recs, Comparator.comparingInt(o -> o[4]));
        answer = new String[recs.length];
        for (int i = 0; i < recs.length; i++) {
            answer[i] = recs[i][0] + " " + recs[i][1] + " " + recs[i][2] + " " + recs[i][3];
        }

        return answer;
    }

}
