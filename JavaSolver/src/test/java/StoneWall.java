import org.junit.jupiter.api.Test;

import java.util.Stack;

/*
    스카이라인 그리기... 유명한 문제.
    어린 시절엔 설명을 들어도 이해를 못 했던 기억이 있는데 직접 다시 풀어보니 감회가 새롭다.
    최소 블럭 수로 스카이라인을 만들어야 한다.
    문제는 중간에 톡 튀어나온 부분이 있을때 그 아래의 공통 부분은 한 블럭으로 처리해야 한다는 점이다.
    즉, 첨탑이 생길 때는(= 높이가 높아질 때) push를 하고, 첨탑이 끝날 때(= 높이가 낮아질 때) pop을 한다.

    1. 현재 인덱스의 높이 < 스택 헤드의 높이 : pop (반복)
    2. 현재 인덱스의 높이 > 스택 헤드의 높이 : push
*/

public class StoneWall {

    @Test
    public void run() {
        System.out.println(
                solution(
                        // new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8}
                        new int[] {5, 5, 5, 5, 6, 7}
                )
        );
    }

    private int solution(int[] H) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int h : H) {
            while (!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
                answer++;
            }

            if (stack.isEmpty() || stack.peek() < h) {
                stack.push(h);
            }
        }

        while (!stack.isEmpty()) {
            stack.pop();
            answer++;
        }

        return answer;
    }
}
