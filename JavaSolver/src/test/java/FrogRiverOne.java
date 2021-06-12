import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/*
merge sort로 nlogn만에 해결하려고 했으나 정렬 이후 list에서 index 관련 예외 처리가 좀 복잡했다.
map을 사용하면 코드는 매우 간결해지지만 for loop 안에서 get을 계속 써야했는데 결과는 O(N)이었다.
중복된 키 값에 대해 처리해야할 때 확실히 map이 편하고 빠르다.
 */

public class FrogRiverOne {

    @Test
    public void run() {
        System.out.println(solution(
                5,
                new int[] {3}
        ));
    }

    private int solution(int X, int[] A) {
        // write your code in Java SE 8

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int cur = map.getOrDefault(A[i], i);

            if (i <= cur) {
                map.put(A[i], i);
            }
        }

        int answer = -1;

        for (int i = 1; i <= X; i++) {
            if (!map.containsKey(i)) {
                return -1;
            } else {
                int cur = map.get(i);
                if (answer < cur) {
                    answer = cur;
                }
            }
        }

        return answer;
    }
}
