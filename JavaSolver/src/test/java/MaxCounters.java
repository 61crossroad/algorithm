import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
카운터 하나의 값을 +1 하는 연산과 모든 카운터를 현재 Max값으로 바꾸는 연산이 있는데, Max 연산이 발생하면 이전까지의 +1은 아무 의미가 없어진다.
그러므로 입력 수열에서 각 Max들 사이의 모든 부분 최대값만 찾으면 된다.
문제는 부분 최대값을 찾으려면 각 부분 수열마다 N만큼의 배열을 초기화해야한다.
N 크기인 정수 배열을 초기화하는데 시간이 얼마나 걸리는가...?

그냥 돌려도 답은 다 맞는데, 역시나 가장 하드한 - Max만 100,000번 존재 - 테스트케이스가 문제였다.
직접 시간을 재보면 5.23초로 시간제한인 5.7초보단 빠르지만 codility에서 테스트하면 6.X초가 나왔다.
결국 의미없이 Max만 올리는 경우는 배열 초기화를 하지 않도록해서 0.012? 초만에 해결하긴 했다.

실제로 최악의 입력값은 +1 연산, Max 연산이 번갈아서 총 100,000번 나오는 경우일 것이다.
Max 연산 50,000번이 모두 실제로 연산을 하기때문에 크기 N인 배열을 50,000번 초기화해야 한다.
이 경우 데이터를 생성해서 돌려보면 2.764초가 나와서 입력 제한에 걸리지 않는다.
 */

public class MaxCounters {

    @Test
    public void run() {
        int[] input = new int[100000];
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                input[i] = 100001;
            } else {
                input[i] = i;
            }
        }

        long sTime = System.currentTimeMillis();

        int[] answer = solution(
                100000,
                input
                // 5,
                // new int[] {3, 4, 4, 6, 1, 4, 4}
                // 100000,
                // new int[] {1, 100000, 2, 100000, 3, 100000, 4, 100000, 5, 100000}
                // 100000,
                // new int[] {1, 100001, 2, 100001, 100000}
        );

        long eTime = System.currentTimeMillis();

        for(int a : answer) {
            System.out.print(a + " ");
        }

        System.out.println("\n" + (eTime - sTime) / 1000.0);
    }
    private int[] solution(int N, int[] A) {
        int[] sub = new int[N];
        int lastKey = -1;
        int lastValue = 0;

        for (int i = 0, max = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                lastValue += max;
                lastKey = i;

                if (0 < max) {
                    sub = new int[N];
                }
                max = 0;
            } else {
                sub[A[i] - 1]++;
                if (max < sub[A[i] - 1]) {
                    max = sub[A[i] - 1];
                }
            }
        }

        int[] answer = new int[N];
        Arrays.fill(answer, lastValue);

        for (int i = lastKey + 1; i < A.length; i++) {
            answer[A[i] - 1]++;
        }

        return answer;
    }
}
