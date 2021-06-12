import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/*
중괄호 변형 문제
문제에서 설명한 과정을 이해한 다음, 재귀호출로 그대로 구현한다.
그 중간에 올바른 괄호인지 확인하는 로직은 스택을 이용하면 간단하게 해결 가능하다.
검증하려는 문자열의 0번 인덱스부터 마지막까지 쭉 스택에 넣고 빼는데,
'('가 들어오면 스택에 넣고, ')'가 들어오면 스택에서 뺀다.
문자열의 끝까지 다 수행했을때 스택 헤드가 0이 아니면 올바른 괄호 문자열이 아니다.
굳이 Map을 쓸 필요는 없었지만 코드를 이해하기 더 편할 것 같아서 해쉬맵을 사용했다.
*/

public class ParenthesisConvert {

    @Test
    public void run() {
        System.out.println(solution("()))((()"));
    }

    private String solution(String p) {
        // 1. return null
        if ("".equals(p) || p == null) {
            return "";
        }

        // 2. divide string
        Map<String, String> uv = divide(p);
        String u = uv.get("u");
        String v = uv.get("v");

        // 3. validate u
        if (validate(u)) {
            String vResult = solution(v);

            // System.out.println("\"" + u + "\"+" + vResult);

            // 3-1. return
            return u + vResult;
        } else {
            String result = "(" + solution(v) + ")";

            if (4 <= u.length()) {
                StringBuilder uReverse = new StringBuilder();

                for (int i = 1; i + 1 < u.length(); i++) {
                    uReverse.append(getReverseParen(u.charAt(i)));
                }
                // System.out.println(u + " -> " + uReverse.toString());

                result += uReverse.toString();
            }

            // System.out.println("\"" + result + "\"");

            return result;
        }
    }

    private Map<String, String> divide(String w) {
        int length = w.length();

        int left, right, i;
        for (left = 0, right = 0, i = 0; i < length; i++) {
            if (w.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                i++;
                break;
            }
        }

        String u, v;
        if (i < length) {
            u = w.substring(0, i);
            v = w.substring(i, length);
        } else {
            u = w;
            v = "";
        }

        // System.out.println(w + " = " + u + " + " + v);

        Map<String, String> uv = new HashMap<String, String>();
        uv.put("u", u);
        uv.put("v", v);

        return uv;
    }

    private boolean validate(String u) {
        int stack = 0;
        for (int i = 0; i < u.length() && 0 <= stack; i++) {
            if (u.charAt(i) == '(') {
                stack++;
            } else {
                stack--;
            }
        }

        return stack == 0;
    }

    private char getReverseParen(char c) {
        if (c == '(') {
            return ')';
        } else {
            return '(';
        }
    }
}
