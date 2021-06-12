import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Nesting {

    @Test
    public void run() {
        System.out.println(
                solution("())"));
    }

    private int solution(String S) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            String cur = S.substring(i, i + 1);

            if (cur.equals("(")) {
                stack.push(cur);
            } else if (stack.isEmpty()) {
                return 0;
            } else {
                String pop = stack.pop();
                if (!pop.equals("(")) {
                    return 0;
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
