import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Dominator {

    @Test
    public void run() {
        System.out.println(solution(
                // new int[] {3, 4, 3, 2, 3, -1, 3, 3}
                new int[] {1, 2, 1}));
    }

    private int solution(int[] A) {
        // write your code in Java SE 8

        if (A.length == 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int a : A) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else if (stack.peek() == a) {
                stack.push(a);
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return -1;
        } else {
            int candidate = stack.peek();
            int cnt = 0;
            int answer = -1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == candidate) {
                    cnt++;
                    answer = i;
                }
            }

            if (A.length / 2 + 1 <= cnt) {
                return answer;
            } else {
                return -1;
            }
        }
    }
}
