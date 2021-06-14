import org.junit.jupiter.api.Test;

/*
prefix sum을 응용해서 뒤에서부터 suffix avg를 만든다.

i번째에서 고려할 경우의 수:
1. i+1번째의 avg에 붙인다
2. i ~ (i + 1)로 2개짜리 slice를 만든다
 */
public class MinAvgTwoSlice {

    @Test
    public void run() {
//        int[] A = {4, 2, 2, 5, 1, 5, 8};
//        int[] A = {5, 1, 5, 8, 4, 2, 2};
        int[] A = {1, 2};
        System.out.println(solution(A));
    }

    public int solution(int[] A) {
        Suffix[] sums = new Suffix[A.length - 1];
        sums[A.length - 2] = new Suffix();
        sums[A.length - 2].end = A.length - 1;
        sums[A.length - 2].sum = A[A.length - 2] + A[A.length - 1];
        sums[A.length - 2].avg = sums[A.length - 2].sum / 2;

        for (int i = A.length - 3; i >= 0; i--) {
            double newAvg = (double) (A[i] + A[i + 1]) / 2;
            double appendAvg = (sums[i + 1].sum + A[i]) / (sums[i + 1].end - i + 1);

            sums[i] = new Suffix();
            if (appendAvg < newAvg) {
                sums[i].end = sums[i + 1].end;
                sums[i].sum = sums[i + 1].sum + A[i];
                sums[i].avg = appendAvg;
            } else {
                sums[i].end = i + 1;
                sums[i].sum = A[i] + A[i + 1];
                sums[i].avg = newAvg;
            }
        }

        double avg = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (avg > sums[i].avg) {
                avg = sums[i].avg;
                index = i;
            }
        }

        return index;
    }

    static class Suffix {
        double sum;
        double avg;
        int end;
    }
}
