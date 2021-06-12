import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/*
    오락실 격투게임 끝나고 이름 AAA 올리는 로직으로 문제를 만들었다...
    간단한 발상으로 신속하게 풀기위해 다음과 같은 전략을 사용했다.
    1. 커서가 있는 위치에서 현재 알파벳이 만들어야하는 알파벳과 다르면 무조건 거기서 위/아래 동작으로 알파벳을 맞추는게 최선의 동작이다.
    (이 조건때문에 문제를 그리디에 넣은 것 같다)
    2. 커서의 좌우 이동은 맨 뒤, 맨 앞으로 점프 기능이 있기 때문에 돌아다녀야 한다.
    2번 조건때문에 BFS를 사용했고, 상태공간트리는 다음 3가지 경우가 들어간다.
    (1) 위/아래 레버로 알파벳을 맞추는 경우
    (2) 좌 레버로 왼쪽으로 이동
    (3) 우 레버로 오른쪽으로 이동
    3가지 경우를 넣으면서 BFS 돌리면 잘 나온다...
    다만, 여기서 문제의 조건을 더 분석해보면 이 문제의 답은 결국
    * 각 문자당 변환 횟수 + 좌/우 이동으로 커서 이동 최소 횟수
    로 이뤄지고 두 가지는 독립적으로 카운트해도 된다.
*/

public class Joystick {

    @Test
    public void run() {
        System.out.println("\n" + solution("ABABAAAAABA"));
        /*
        JAZ 11
        JEROEN	56
        JAN	23
        BBBAAAB 8
        ABABAAAAABA 10
        */
    }

    static class Cursor {
        int index;
        String str;
        int cnt;
        int action;
    }

    public int solution(String name) {
        int answer = Integer.MAX_VALUE;
        int len = name.length();

        Cursor init = new Cursor();
        init.str = "A".repeat(len);
        init.index = 0; init.cnt = 0; init.action = 0;

        Queue<Cursor> queue = new LinkedList<>();
        queue.add(init);

        while (!queue.isEmpty()) {
            Cursor cur = queue.poll();

            if (cur.str.equals(name)) {
                if (answer > cur.cnt) {
                    answer = cur.cnt;
                }
            } else {
                if (!cur.str.substring(cur.index, cur.index + 1).equals(name.substring(cur.index, cur.index + 1))) {
                    Cursor next = new Cursor();
                    int gap = Math.abs((int)(cur.str.charAt(cur.index) - name.charAt(cur.index)));
                    if (13 < gap) gap = 26 - gap;
                    next.cnt = cur.cnt + gap;
                    next.str = cur.str.substring(0, cur.index) + name.substring(cur.index, cur.index + 1) + cur.str.substring(cur.index + 1, len);
                    next.index = cur.index;
                    next.action = 0;
                    queue.add(next);
                } else {
                    if (cur.action != 4) {
                        Cursor left = new Cursor();
                        left.cnt = cur.cnt + 1;
                        left.str = cur.str;
                        left.index = (cur.index - 1 < 0) ? len - 1 : cur.index - 1;
                        left.action = 3;
                        queue.add(left);
                    }

                    if (cur.action != 3) {
                        Cursor right = new Cursor();
                        right.cnt = cur.cnt + 1;
                        right.str = cur.str;
                        right.index = (len == cur.index + 1) ? 0 : cur.index + 1;
                        right.action = 4;
                        queue.add(right);
                    }
                }
            }
        }

        return answer;
    }
}
