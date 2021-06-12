import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
코딜리티 Lessons 문제
Map의 Hash 알고리즘인 Red-Black Tree의 시간복잡도를 정확히 몰라서 대략 O(N * logN) 정도 나오겠거니 했는데
결과페이지를 보니까 입력값에 따라서 O(N) ~ O(N * logN)까지 나온다고 한다.
사실 Map의 Hash tree는 입력에 따라서 LinkedList나 Tree를 번갈아 사용하기때문에 정해진 시간복잡도는 없는게 맞지만
최악의 경우 logN이라고 가정하면 될 것 같다.
 */

public class OddOccurrencesInArray {

    @Test
    public void run() {
        System.out.println(solution(
                new int[] {2, 2, 2, 2, 4}
        ));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        Map<Integer, Integer> check = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int cnt = check.getOrDefault(A[i], 0);
            check.put(A[i], cnt + 1);
        }

        Iterator<Integer> it = check.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            int cnt = check.get(key);
            if (cnt % 2 == 1) {
                return key;
            }
        }
        return 0;
    }
}
