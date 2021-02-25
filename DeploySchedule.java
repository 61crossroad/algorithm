/*
    링크드 리스트를 이용한 간단한 스택 문제
    스택은 고정된 위치? 인덱스에서 add(=tail), remove(=head)만 수행하므로 각각 O(1)의 시간복잡도를 가지는 링크드 리스트가 효율적이다.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            double remain = 100 - progresses[i];
            int day = (int) Math.ceil(remain / speeds[i]);
            list.add(day);
        }

        List<Integer> result = new ArrayList<>();
        while (!list.isEmpty()) {
            int cur = list.remove(0);
            int cnt = 1;

            while (!list.isEmpty() && list.get(0) <= cur) {
                list.remove(0);
                cnt++;
            }

            result.add(cnt);
        }

        answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[] answer = sol.solution(
            new int[] {93, 30, 55},
            new int[] {1, 30, 5})
        ;

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
